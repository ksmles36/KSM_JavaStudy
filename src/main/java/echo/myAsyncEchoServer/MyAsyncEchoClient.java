package echo.myAsyncEchoServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Scanner;
import java.util.concurrent.Future;

public class MyAsyncEchoClient {

    public static void main(String[] args) {
        connectAsyncEchoServer("localhost", 9002);
    }

    private static void connectAsyncEchoServer(String host, int port) {
        try {
            AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
            Future future = client.connect(new InetSocketAddress("localhost", 9002));
            future.get();

            System.out.println("client is started : " + client.isOpen());

            Scanner scanner = new Scanner(System.in);
            String message;

            while (true) {
                System.out.print("Message to server : ");
                message = scanner.nextLine();
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                Future result = client.write(buffer);

                while (!result.isDone()) {}

                if (message.equalsIgnoreCase("exit")) {
                    client.close();
                    break;
                }

                client.read(buffer);
                String s = new String(buffer.array()).trim();
                System.out.println("Message from Server : " + s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
