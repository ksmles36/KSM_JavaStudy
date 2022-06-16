package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
    int servicePort = 0;
    int backlog = 128;

    ServerSocket serverSocket = null;

    class EchoThread implements Runnable {
        Socket clientSocket = null;
        public EchoThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true)) {
                String input;

                for(;(input = br.readLine()) != null;) {
                    if (input.trim().equalsIgnoreCase("exit")) break;
                    System.out.println(String.format("recv: [%s]", input));
                    out.println(input);
                }

                clientSocket.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public EchoServer(int port, int backlog) {
        this.servicePort = port;
        this.backlog = backlog;
    }

    public EchoServer listen() {
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
        new EchoServer(8000, 1024).listen().accept();

    }
}
