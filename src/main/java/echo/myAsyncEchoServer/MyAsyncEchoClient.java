package echo.myAsyncEchoServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class MyAsyncEchoClient {

    public static void main(String[] args) {
        connectAsyncEchoServer("localhost", 9002);
    }

    private static void connectAsyncEchoServer(String host, int port) {
        try {
            AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
            channel.connect(new InetSocketAddress(host, port));
            System.out.println("서버에 연결됨");

            Scanner sc = new Scanner(System.in);

            ByteBuffer byteBuffer;
            Charset charset = Charset.forName("UTF-8");

            for (; ; ) {
                System.out.print("to Server : ");
                String inputData = sc.nextLine();

                byteBuffer = charset.encode(inputData);
                channel.write(byteBuffer);

                byteBuffer = ByteBuffer.allocate(20);
                channel.read(byteBuffer);
                byteBuffer.flip();

                String receiveStr = charset.decode(byteBuffer).toString();

                System.out.println("from Server : " + receiveStr);
                if (inputData.trim().equalsIgnoreCase("exit")) {
                    channel.close();
                    System.out.println("서버 연결 종료");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
