package echo.myThreadEchoServer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class MyThreadWriteThread extends Thread {

    SocketChannel channel;
    Scanner sc = null;

    public MyThreadWriteThread(SocketChannel channel, Scanner sc) {
        this.channel = channel;
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            System.out.println("MyThreadWriteThread started : " + channel.isOpen());

            ByteBuffer byteBuffer;
            Charset charset = Charset.forName("UTF-8");

            while (true) {
                Thread.sleep(100);

                System.out.print("to server : ");
                String inputData = sc.nextLine();

                byteBuffer = charset.encode(inputData);
                channel.write(byteBuffer);
            }

        } catch (IOException e) {
            if (Global.exit) {
                System.out.println("Write thread is exited");
                try {
                    channel.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
