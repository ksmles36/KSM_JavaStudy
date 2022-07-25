package echo.myAsyncEchoServer2.twoThread;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class WriteThread extends Thread{

    private AsynchronousSocketChannel clientChannel;

    public WriteThread(AsynchronousSocketChannel clientChannel) {
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
                clientChannel.write(buffer);
            }
        } catch (Exception e) {
        }finally {
            String message = "bye~~!";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            buffer.flip();
            clientChannel.write(buffer);
        }
    }

}
