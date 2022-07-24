package echo.myThreadEchoServer;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class MyThreadReadThread extends Thread {

    SocketChannel channel;

    public MyThreadReadThread(SocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            System.out.println("\nMyThreadReadThread started : " + channel.isOpen());

            ByteBuffer buffer;
            Charset charset = Charset.forName("UTF-8");

            while (true) {
                buffer = ByteBuffer.allocate(20);
                channel.read(buffer);
                buffer.flip();
                String readText = charset.decode(buffer).toString();
                Global.queue.add(readText);
                System.out.println("Message from Server : " + readText);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
