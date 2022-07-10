package echo.myAsyncEchoServer;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class MyAsyncEchoServer {

    private int port;
    private int backlogSize;
    private AsynchronousSocketChannel asynchronousSocketChannel;
    private InetSocketAddress inetSocketAddress;

    public MyAsyncEchoServer(int port, int backlogSize) {
        this.port = port;
        this.backlogSize = backlogSize;
    }

    private MyAsyncEchoServer bind() {
        try {
            asynchronousSocketChannel = asynchronousSocketChannel.open();
            inetSocketAddress = new InetSocketAddress(port);
            asynchronousSocketChannel.bind(inetSocketAddress);
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
//        for (; ; ) {
            try {
                Future<Void> connect = asynchronousSocketChannel.connect(inetSocketAddress);
                System.out.println("connect = " + connect);
                new Thread(new MyAsyncEchoThread(connect)).start();

            } catch (Exception e) {
                e.printStackTrace();
            }
//        }
    }

    public static void main(String[] args) {
        new MyAsyncEchoServer(9002, 1024).bind().listen().accept();
    }
}
