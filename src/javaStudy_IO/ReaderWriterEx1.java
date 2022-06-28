package javaStudy_IO;

import java.io.File;
import java.io.FileInputStream;

public class ReaderWriterEx1 {

    public static void main(String[] args) {

        useFileInputStream();
        useFileReader();

    }

    private static void useFileInputStream() {
        try {
            File file = new File("C:\\Users\\kim\\Documents\\textFile05.txt");
            FileInputStream fileInputStream = new FileInputStream(file);

            int data = 0;
            while ((data = fileInputStream.read()) != -1) {
                System.out.print((char)data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void useFileReader() {



    }

}
