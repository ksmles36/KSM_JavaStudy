package echo.myThreadEchoServer;


import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class MyThreadEchoClient {

    public static void main(String[] args) throws InterruptedException {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("localhost", 9005));

            Thread writeThread = new Thread(new MyThreadWriteThread(channel));
            Thread readThread = new Thread(new MyThreadReadThread(channel));

            writeThread.start();
            readThread.start();

        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
