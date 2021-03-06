package echo.myThreadEchoServer;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class MyThreadEchoServer extends Thread {

    int port;
    int backlogSize;
    ServerSocketChannel serverSocketChannel;

    public MyThreadEchoServer(int port, int backlogSize) {
        this.port = port;
        this.backlogSize = backlogSize;
    }

    public void run() {
        String text = "bye~~";
        Global.queue.add(text);

        try {
            Thread.sleep(100);
            serverSocketChannel.close();
        } catch (Exception e) {}
    }


    private MyThreadEchoServer bind() {
        try {
            ServerSocketChannel open = ServerSocketChannel.open();
            open.configureBlocking(true);
            serverSocketChannel = open.bind(new InetSocketAddress(port), backlogSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    private MyThreadEchoServer listen() {
        try {
            System.out.println(String.format("Listen %d ...", port));

        } catch (Exception e) {
        }
        return this;
    }

    private void accept() {
        for (; ; ) {
            try {
                SocketChannel clientSocketChannel = serverSocketChannel.accept();
                System.out.println("clientSocketChannel = " + clientSocketChannel);
                new Thread(new MyThreadEchoThread(clientSocketChannel)).start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThreadEchoServer server = new MyThreadEchoServer(9005, 1024);
        Runtime.getRuntime().addShutdownHook(server);
        server.bind().listen().accept();
    }
}
