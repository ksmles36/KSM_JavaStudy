package echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {

        try {
            Socket clientSocket = new Socket("localhost", 8000);
            System.out.println("서버에 연결됨");

            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Scanner sc = new Scanner(System.in);

            while(true){
                System.out.print("to Server : ");
                String inputData = sc.nextLine();
                if(inputData.equalsIgnoreCase("exit")) {
                    clientSocket.close();
                    break;
                }

                pw.print(inputData);
                pw.flush();

                System.out.println("from Server : " + br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
