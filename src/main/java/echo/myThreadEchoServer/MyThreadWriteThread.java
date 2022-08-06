package echo.myThreadEchoServer;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class MyThreadWriteThread extends Thread{

    SocketChannel channel;

    public MyThreadWriteThread(SocketChannel channel){
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            System.out.println("MyThreadWriteThread started : " + channel.isOpen());

            ByteBuffer byteBuffer;
            Charset charset = Charset.forName("UTF-8");

            Scanner sc = new Scanner(System.in);

            while (true) {
                Thread.sleep(100);
                System.out.print("to server : ");
                String inputData = sc.nextLine();

                byteBuffer = charset.encode(inputData);
                channel.write(byteBuffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
