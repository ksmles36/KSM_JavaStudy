package echo.myThreadEchoServer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class MyThreadReadThread extends Thread {

    SocketChannel channel;
    Scanner sc = null;

    public MyThreadReadThread(SocketChannel channel, Scanner sc) {
        this.channel = channel;
        this.sc = sc;
    }

    @Override
    public void run() {
        System.out.println("\nMyThreadReadThread started : " + channel.isOpen());

        ByteBuffer buffer = null;
        Charset charset = Charset.forName("UTF-8");

        try {
            while (true) {
                buffer = ByteBuffer.allocate(20);

                if (channel.finishConnect()) {
                    channel.read(buffer);
                    buffer.flip();
                    String readText = charset.decode(buffer).toString();

                    if (!readText.isEmpty())
                        System.out.println("\nMessage from Server : " + readText + "\n");

                    if (readText.equalsIgnoreCase("bye~~")) {
                        Global.exit = true;
                        sc.close();
                        channel.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
