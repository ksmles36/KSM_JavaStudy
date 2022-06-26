package echo.bind;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class EchoServerBind {
    int servicePort = 0;
    int backlog = 128;

    ServerSocket serverSocket = null;

    class EchoThread implements Runnable {
        Socket clientSocket = null;
        public EchoThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                this.clientSocket.setSoTimeout(10);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            int charData=0;

            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true)) {
                for (;;) {
                    ArrayList<String> readData = new ArrayList<String>();

                    try {
                        for (;(charData=clientSocket.getInputStream().read()) != -1;) {
                            if (charData == 0) break;
                            readData.add(charData+"");
                        }
                    }
                    catch (SocketTimeoutException e) {}

                    if (charData == -1) {
                        System.out.println("client socket closed..");
                        clientSocket.close();
                        return;
                    }

                    if (readData.size() < 1) continue;

                    byte[] readBytes = new byte[readData.size()];
                    for (int i=0;i<readBytes.length;i++) {
                        int charValue = Integer.parseInt((String)readData.get(i));
                        readBytes[i] = (byte)charValue;
                    }

                    String recvStr = new String(readBytes);

                    if (recvStr.trim().equalsIgnoreCase("exit")) break;
                    System.out.println(String.format("recv: [%s]", recvStr));
                    out.println(recvStr);
                }

                clientSocket.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public EchoServerBind(int port, int backlog) {
        this.servicePort = port;
        this.backlog = backlog;
    }

    public EchoServerBind listen() {
        try {
            serverSocket = new ServerSocket(servicePort, backlog);
            System.out.println(String.format("Listen %d success..", servicePort));
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return this;
    }

    public void accept() {
        for (;;) {
            try {
                Socket clientSocket = serverSocket.accept();
                new Thread(new EchoThread(clientSocket)).start();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new EchoServerBind(8000, 1024).listen().accept();
    }
}


