package echo.myAsyncEchoServer2.twoThread;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ReadThread extends Thread{

    private AsynchronousSocketChannel clientChannel;

    public ReadThread(AsynchronousSocketChannel clientChannel) {
        this.clientChannel = clientChannel;
    }

    @Override
    public void run() {
        try {
            while ((clientChannel != null) && (clientChannel.isOpen())) {
                ByteBuffer buffer = ByteBuffer.allocate(20);
                Future result = clientChannel.read(buffer);

                result.get(10, TimeUnit.SECONDS);

                buffer.flip();
                String message = new String(buffer.array()).trim();
                System.out.println("Messages from client : " + message);
                if (message.equalsIgnoreCase("exit")) {
                    clientChannel.close();
                    break;
                }

            }
        } catch (Exception e) {
        }
    }

}
