package echo.myAsyncEchoServer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class MyAsyncEchoThread extends Thread {

    private AsynchronousSocketChannel clientChannel;

    public MyAsyncEchoThread(AsynchronousSocketChannel clientChannel) {
        this.clientChannel = clientChannel;
    }

    @Override
    public void run() {
        try {
            while ((clientChannel != null) && (clientChannel.isOpen())) {
                ByteBuffer buffer = ByteBuffer.allocate(20);
                Future result = clientChannel.read(buffer);

                while (!result.isDone()) {}

                buffer.flip();
                String message = new String(buffer.array()).trim();
                System.out.println("Messages from client : " + message);
                if (message.equalsIgnoreCase("exit")) {
                    clientChannel.close();
                    break;
                }

                buffer.flip();
                clientChannel.write(buffer);
            }
        } catch (Exception e) {
        }
    }
}
