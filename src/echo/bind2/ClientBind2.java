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
            channel.configureBlocking(true);  //논블로킹 설정
            boolean isConnect = channel.connect(new InetSocketAddress(host, port));
            System.out.println("isConnect = " + isConnect);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
