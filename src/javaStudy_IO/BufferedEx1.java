package javaStudy_IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedEx1 {

    public static void main(String[] args) {

        notUseBuffered();
        useBuffered();

    }

    private static void notUseBuffered() {
        try {
            FileInputStream fis1 = new FileInputStream("C:\\Users\\kim\\Pictures\\SampleJPGImage_1MB.jpg");
            long start = System.currentTimeMillis();
            while (fis1.read() != -1) {
            }
            long end = System.currentTimeMillis();
            System.out.println("버퍼를 사용하지 않았을 때 : " + (end-start) + "ms 소요");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void useBuffered() {
        try {
            FileInputStream fis2 = new FileInputStream("C:\\Users\\kim\\Pictures\\SampleJPGImage_1MB.jpg");
            BufferedInputStream br = new BufferedInputStream(fis2);
            long start = System.currentTimeMillis();
            while (br.read() != -1) {
            }
            long end = System.currentTimeMillis();
            System.out.println("버퍼를 사용했을 때 : " + (end-start) + "ms 소요");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
