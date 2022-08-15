package echo.myThreadEchoServer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class MyThreadServerWriteThread extends Thread{

    private SocketChannel channel;
    Scanner sc = new Scanner(System.in);

    public MyThreadServerWriteThread(SocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {

        try {
            System.out.println("MyThreadServerWriteThread started : " + channel.isOpen());

            ByteBuffer byteBuffer;
            Charset charset = Charset.forName("UTF-8");

            while (true) {
                Thread.sleep(100);

                System.out.print("to client : ");
                String inputData = sc.nextLine();

                byteBuffer = charset.encode(inputData);
                channel.write(byteBuffer);
            }

        } catch (IOException e) {
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
