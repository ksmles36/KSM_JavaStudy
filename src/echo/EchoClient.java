package echo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {

        connectEchoServer("121.167.147.22", 8000);

    }

    private static void connectEchoServer(String host, int port) {
        try {
            SocketChannel clientSocket = SocketChannel.open();
            clientSocket.configureBlocking(true);
            clientSocket.connect(new InetSocketAddress(host, port));
            System.out.println("서버에 연결됨");

            Scanner sc = new Scanner(System.in);

            ByteBuffer sendByteBuffer;
            ByteBuffer receiveByteBuffer;
            Charset charset = Charset.forName("UTF-8");

            while(true){
                System.out.print("to Server : ");
                String inputData = sc.nextLine();

                if(inputData.trim().equalsIgnoreCase("exit")) {
                    clientSocket.close();
                    System.out.println("서버 연결 종료");
                    break;
                }

                sendByteBuffer = charset.encode(inputData);
                clientSocket.write(sendByteBuffer);

                receiveByteBuffer = ByteBuffer.allocate(1024);
                clientSocket.read(receiveByteBuffer);
                receiveByteBuffer.flip();

                String receiveStr = charset.decode((receiveByteBuffer)).toString();

                System.out.println("from Server : " + receiveStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
