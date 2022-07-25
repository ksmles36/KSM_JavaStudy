package echo.myAsyncEchoServer2.twoThread;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class Server {

    private int port;
    private int backlogSize;
    private AsynchronousServerSocketChannel serverChannel;
    private InetSocketAddress inetSocketAddress;

    public Server(int port, int backlogSize) {
        this.port = port;
        this.backlogSize = backlogSize;
    }

    private Server bind() {
        try {
            serverChannel = AsynchronousServerSocketChannel.open();
            inetSocketAddress = new InetSocketAddress("localhost", port);
            serverChannel.bind(inetSocketAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    private Server listen() {
        try {
            System.out.println(String.format("Listen %d ...", port));

        } catch (Exception e) {
        }
        return this;
    }

    private void accept() {
        for (; ; ) {
            try {
                System.out.println("Waiting for client to connect...");
                Future acceptResult = serverChannel.accept();
                AsynchronousSocketChannel clientChannel = (AsynchronousSocketChannel) acceptResult.get();
                System.out.println("clientChannel = " + clientChannel);
                new Thread(new ReadThread(clientChannel)).start();
                new Thread(new WriteThread(clientChannel)).start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server(9004, 1024).bind().listen().accept();
    }

}
