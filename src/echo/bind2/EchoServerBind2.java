package echo.bind2;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerBind2 {

    int port;
    int backlogSize;
    ServerSocket serverSocket;

    public EchoServerBind2(int port, int backlogSize) {
        this.port = port;
        this.backlogSize = backlogSize;
    }

    private EchoServerBind2 bind() {
        try {
            serverSocket = new ServerSocket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(port);
            serverSocket.bind(inetSocketAddress, backlogSize);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return this;
    }

    private EchoServerBind2 listen() {
        try {
            System.out.println(String.format("Listen %d ...", port));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    private void accept() {
        try{
            Socket clientSocket = serverSocket.accept();
            System.out.println("clientSocket = " + clientSocket);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new EchoServerBind2(9000, 2048).bind().listen().accept();
    }

}
