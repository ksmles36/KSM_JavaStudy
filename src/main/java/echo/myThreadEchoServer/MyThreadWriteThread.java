package echo.myThreadEchoServer;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

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

            while (true) {
                if(!Global.queue.isEmpty()){
                    String pollText = Global.queue.poll();
                    System.out.print("Message to server : " + pollText);
                    byteBuffer = charset.encode(pollText);
                    channel.write(byteBuffer);

                    if (pollText.equalsIgnoreCase("exit")) {
                        channel.close();
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
