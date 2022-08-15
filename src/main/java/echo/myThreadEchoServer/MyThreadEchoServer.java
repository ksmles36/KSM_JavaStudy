package echo.myThreadEchoServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class MyThreadEchoServer extends Thread {

    int port;
    int backlogSize;
    ServerSocketChannel serverSocketChannel;
    SocketChannel clientSocketChannel;

    public MyThreadEchoServer(int port, int backlogSize) {
        this.port = port;
        this.backlogSize = backlogSize;
    }

    @Override
    public void run() {
        try {
            String text = "bye~~";
            Charset charset = Charset.forName("UTF-8");
            ByteBuffer byteBuffer = charset.encode(text);
            clientSocketChannel.write(byteBuffer);

            serverSocketChannel.close();
            System.out.println("bye inserted !");
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
                clientSocketChannel = serverSocketChannel.accept();
                System.out.println("clientSocketChannel = " + clientSocketChannel);
                new Thread(new MyThreadEchoThread(clientSocketChannel)).start();
                new Thread(new MyThreadServerWriteThread(clientSocketChannel)).start();

            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        MyThreadEchoServer server = new MyThreadEchoServer(9095, 1024);
        Runtime.getRuntime().addShutdownHook(server);
        server.bind().listen().accept();
    }
}
