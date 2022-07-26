package echo.myThreadEchoServer;


import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class MyThreadEchoClient {

    public static void main(String[] args) throws InterruptedException {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(true);
            channel.connect(new InetSocketAddress("localhost", 9005));

            Thread writeThread = new Thread(new MyThreadWriteThread(channel));
            Thread readThread = new Thread(new MyThreadReadThread(channel));

            while (true) {
//                if (Global.queue.isEmpty()) {
                    System.out.print("\nto Server : ");
                    Scanner sc = new Scanner(System.in);
                    String inputText = sc.nextLine();
                    Global.queue.add(inputText);

                    writeThread.start();
                    Thread.sleep(1000);
                    readThread.start();
                    Thread.sleep(1000);
//                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
