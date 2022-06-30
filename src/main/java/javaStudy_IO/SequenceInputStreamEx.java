package javaStudy_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamEx {

    public static void main(String[] args) {
        sequenceStreamEx1();
        sequenceStreamEx2();
    }

    private static void sequenceStreamEx1() {
        try {
            File file1 = new File("C:\\Users\\kim\\Documents\\textFile01.txt");
            File file2 = new File("C:\\Users\\kim\\Documents\\textFile02.txt");
            FileInputStream fileIn1 = new FileInputStream(file1);
            FileInputStream fileIn2 = new FileInputStream(file2);
            SequenceInputStream sequenceInputStream = new SequenceInputStream(fileIn1, fileIn2);

            File resultFile = new File("C:\\Users\\kim\\Documents\\textFileResult.txt");
            FileOutputStream fileOut = new FileOutputStream(resultFile);

            int data = 0;
            while ((data = sequenceInputStream.read()) != -1) {
                fileOut.write((char)data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sequenceStreamEx2() {
        try {
            File file1 = new File("C:\\Users\\kim\\Documents\\textFile01.txt");
            File file2 = new File("C:\\Users\\kim\\Documents\\textFile02.txt");
            File file3 = new File("C:\\Users\\kim\\Documents\\textFile03.txt");
            File file4 = new File("C:\\Users\\kim\\Documents\\textFile04.txt");
            FileInputStream fileIn1 = new FileInputStream(file1);
            FileInputStream fileIn2 = new FileInputStream(file2);
            FileInputStream fileIn3 = new FileInputStream(file3);
            FileInputStream fileIn4 = new FileInputStream(file4);

            Vector<FileInputStream> vector = new Vector<>();
            vector.add(fileIn1);
            vector.add(fileIn2);
            vector.add(fileIn3);
            vector.add(fileIn4);

            Enumeration<FileInputStream> enumeration = vector.elements();
            SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);

            File resultFile = new File("C:\\Users\\kim\\Documents\\textFileResult2.txt");
            FileOutputStream fileOut = new FileOutputStream(resultFile);

            int data = 0;
            while ((data = sequenceInputStream.read()) != -1) {
                fileOut.write((char)data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
