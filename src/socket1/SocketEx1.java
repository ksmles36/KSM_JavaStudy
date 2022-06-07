package socket1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class SocketEx1 {

    public static void main(String[] args) {

//        socketConnectEx1();
//        socketConnectEx2();
//        socketConnectEx3();
        socketConnectEx4();

    }

    private static void socketConnectEx4() {
        try {
            Socket s = new Socket("223.130.200.107", 80);
            char data[] = new char[1024];
            int len;
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            out.println("리퀘스트");
            while ((len = in.read(data)) != -1)
                System.out.println(new String(data, 0, len));

            System.out.println(s.isConnected());
            s.close();
            System.out.println(s.isConnected());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void socketConnectEx3() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 80));

            while(true){
                System.out.println("연결 기다림");
                Socket socket = serverSocket.accept();
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("연결 수락함 " + isa.getHostName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void socketConnectEx1() {
        try {
            Socket socket = new Socket();
            SocketAddress address = new InetSocketAddress("223.130.200.107", 80);
            socket.connect(address, 2000);
            System.out.println(socket.isConnected());
            socket.close();
            System.out.println(socket.isConnected());
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

