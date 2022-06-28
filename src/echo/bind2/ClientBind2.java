package echo.bind2;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ClientBind2 {

    public static void main(String[] args) {

        connectServer("localhost", 9000);

    }

    private static void connectServer(String host, int port) {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress(host, port));
            Thread.sleep(3000);
            System.out.println("isConnect? = " + channel.isConnected());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
