package echo.myEchoServer;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class MyEchoThread_UseIO extends Thread {

    private Socket clientSocket;

    public MyEchoThread_UseIO(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            this.clientSocket.setSoTimeout(10);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

        int readData = 0;

        try {
            for (; ; ) {
                InputStream inputStream = clientSocket.getInputStream();
                ArrayList<String> strList = new ArrayList<>();

                try {
                    while ((readData = inputStream.read()) != -1) {
                        if (readData == 0)
                            break;
                        strList.add(Integer.toString(readData));
                    }
                } catch (SocketTimeoutException e) {}

                if (readData == -1) {
                    clientSocket.close();
                    return;
                }

                if (strList.size() < 1) continue;

                byte[] bytes = new byte[strList.size()];

                for (int i = 0; i < bytes.length; i++) {
                    String s = strList.get(i);
                    int int1 = Integer.parseInt(s);
                    bytes[i] = (byte) int1;
                }

                String writeStr = new String(bytes);

                if(writeStr.equalsIgnoreCase("exit"))
                    break;

                System.out.println("writeStr = " + writeStr);

                OutputStream outputStream = clientSocket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(writeStr);
                printWriter.flush();

            }
            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
