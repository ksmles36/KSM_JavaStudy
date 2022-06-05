package socket1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketEx1 {

    public static void main(String[] args) {
        socketConnectEx1();
//        socketConnectEx2();
    }

    private static void socketConnectEx1() {
        try {
            Socket socket = new Socket();
            SocketAddress address = new InetSocketAddress("223.130.200.107", 80);
            socket.connect(address, 2000);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void socketConnectEx2() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("223.130.200.107", 80));

            System.out.println("연결 기다림");
            Socket socket = serverSocket.accept();

        } catch (IOException e) {
            System.out.println("에러발생!");
            throw new RuntimeException(e);
        }
    }
}

