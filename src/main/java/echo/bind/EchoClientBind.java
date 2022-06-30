package echo.bind;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class EchoClientBind {

    public static void main(String[] args) {

        connectEchoServer("localhost", 9000);

    }

    private static void connectEchoServer(String host, int port) {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(true);  //논블로킹 설정
            channel.connect(new InetSocketAddress(host, port));
            System.out.println("서버에 연결됨");

            Scanner sc = new Scanner(System.in);

            ByteBuffer byteBuffer;
            Charset charset = Charset.forName("UTF-8");

            while(true){
                System.out.print("to Server : ");
                String inputData = sc.nextLine();

                if(inputData.trim().equalsIgnoreCase("exit")) {
                    channel.close();
                    System.out.println("서버 연결 종료");
                    break;
                }

                byteBuffer = charset.encode(inputData);
                channel.write(byteBuffer);

                byteBuffer = ByteBuffer.allocate(128);
                channel.read(byteBuffer);
                byteBuffer.flip();

                String receiveStr = charset.decode((byteBuffer)).toString();

                System.out.println("from Server : " + receiveStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
