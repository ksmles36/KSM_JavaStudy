package echo.myThreadEchoServer;

import java.io.IOException;
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
                        System.out.println("Message from Server : " + readText + "\n");

                    if(readText.equalsIgnoreCase("bye~~")){
                        Global.queue.add(readText);
                        Global.exit = true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("서버가 종료되었습니다.");
            System.out.println("Read 스레드를 종료합니다.");
            try {
                channel.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
