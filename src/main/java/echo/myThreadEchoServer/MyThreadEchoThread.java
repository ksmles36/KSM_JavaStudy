package echo.myThreadEchoServer;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class MyThreadEchoThread extends Thread{

    private SocketChannel channel;

    public MyThreadEchoThread(SocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            ByteBuffer byteBuffer;

            for (; ; ) {
                byteBuffer = ByteBuffer.allocate(20);
                channel.read(byteBuffer);
                byteBuffer.flip();

                String text = "";
                Charset charset = Charset.forName("UTF-8");
                text = charset.decode(byteBuffer).toString();
                System.out.println("\nreceiveText = " + text);

                if (text.equalsIgnoreCase("exit")) {
                    channel.close();
                    break;
                }

                byteBuffer = charset.encode(text);
                channel.write(byteBuffer);
            }
        } catch (Exception e) {
        }
    }

}
