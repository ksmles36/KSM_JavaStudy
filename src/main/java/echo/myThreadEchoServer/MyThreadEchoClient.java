package echo.myThreadEchoServer;


import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class MyThreadEchoClient {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(true);
            channel.connect(new InetSocketAddress("localhost", 9005));


            Thread writeThread = new Thread(new MyThreadWriteThread(channel));
            Thread readThread = new Thread(new MyThreadReadThread(channel));

            System.out.print("\nto Server : ");
            String inputText = sc.nextLine();
            Global.queue.add(inputText);

            writeThread.start();
            Thread.sleep(1000);
            readThread.start();
            Thread.sleep(1000);

            while (true) {
                System.out.print("\nto Server : ");
                inputText = sc.nextLine();
                Global.queue.add(inputText);
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}
