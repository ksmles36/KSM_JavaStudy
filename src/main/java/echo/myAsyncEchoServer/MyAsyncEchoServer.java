package echo.myAsyncEchoServer;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class MyAsyncEchoServer {

    private int port;
    private int backlogSize;
    private AsynchronousServerSocketChannel serverChannel;
    private InetSocketAddress inetSocketAddress;

    public MyAsyncEchoServer(int port, int backlogSize) {
        this.port = port;
        this.backlogSize = backlogSize;
    }

    private MyAsyncEchoServer bind() {
        try {
            serverChannel = AsynchronousServerSocketChannel.open();
            inetSocketAddress = new InetSocketAddress("localhost", port);
            serverChannel.bind(inetSocketAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    private MyAsyncEchoServer listen() {
        try {
            System.out.println(String.format("Listen %d ...", port));

        } catch (Exception e) {
        }
        return this;
    }

    private void accept() {
            try {
                System.out.println("Waiting for client to connect...");
                Future acceptResult = serverChannel.accept();
                AsynchronousSocketChannel clientChannel = (AsynchronousSocketChannel) acceptResult.get();
                System.out.println("clientChannel = " + clientChannel);
                new Thread(new MyAsyncEchoThread(clientChannel)).start();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        new MyAsyncEchoServer(9002, 1024).bind().listen().accept();
    }
}
