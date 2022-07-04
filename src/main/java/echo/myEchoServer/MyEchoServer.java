package echo.myEchoServer;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyEchoServer {

    int port;
    int backlogSize;
    ServerSocket serverSocket;

    public MyEchoServer(int port, int backlogSize) {
        this.port = port;
        this.backlogSize = backlogSize;
    }

    private MyEchoServer bind() {
        try {
            serverSocket = new ServerSocket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(port);
            serverSocket.bind(inetSocketAddress, backlogSize);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    private MyEchoServer listen() {
        try {
            System.out.println(String.format("Listen %d ...", port));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    private void accept() {
        for (; ; ) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("clientSocket = " + clientSocket);
                new Thread(new MyEchoThread(clientSocket)).start();
                break;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyEchoServer(9001, 1024).bind().listen().accept();
    }

}
