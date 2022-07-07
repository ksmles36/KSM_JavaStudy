package echo.myEchoServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class MyEchoClient {

    public static void main(String[] args) {

        connectEchoServer("localhost", 9001);

    }

    private static void connectEchoServer(String host, int port) {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(true);
            channel.connect(new InetSocketAddress(host, port));
            System.out.println("서버에 연결됨");

            Scanner sc = new Scanner(System.in);

            ByteBuffer byteBuffer;
            Charset charset = Charset.forName("UTF-8");

            while(true){
                System.out.print("to Server : ");
                String inputData = sc.nextLine();



                byteBuffer = charset.encode(inputData);
                channel.write(byteBuffer);

                byteBuffer = ByteBuffer.allocate(20);
                channel.read(byteBuffer);
                byteBuffer.flip();

                String receiveStr = charset.decode(byteBuffer).toString();

                System.out.println("from Server : " + receiveStr);
                if(inputData.trim().equalsIgnoreCase("exit")) {
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
