package echo.myAsyncEchoServer;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.Future;

public class MyAsyncEchoThread extends Thread {

    private Future future;

    public MyAsyncEchoThread(Future<Void> connect) {
        this.future = connect;
        System.out.println("new Thread().start()");
        try {
//            this.clientSocket.setSoTimeout(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            ByteBuffer byteBuffer;

            for (; ; ) {
                SocketChannel channel = (SocketChannel) future.get();
                byteBuffer = ByteBuffer.allocate(20);
                channel.read(byteBuffer);
                byteBuffer.flip();

                String text = "";
                Charset charset = Charset.forName("UTF-8");
                text = charset.decode(byteBuffer).toString();
                System.out.println("receiveText = " + text);

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
