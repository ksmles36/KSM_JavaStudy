package echo.myThreadEchoServer;


import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class MyThreadEchoClient {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("localhost", 9095));

            Thread writeThread = new Thread(new MyThreadWriteThread(channel, sc));
            Thread readThread = new Thread(new MyThreadReadThread(channel, sc));

            writeThread.start();
            readThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for(;;){
            Thread.sleep(10);
            if (Global.exit) {
                System.exit(0);
            }
        }
    }
}
