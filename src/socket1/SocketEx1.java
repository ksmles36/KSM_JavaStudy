package socket1;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketEx1 {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket();
            SocketAddress address = new InetSocketAddress("223.130.200.107", 80);
            socket.connect(address, 2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

