package asciiEx;

import java.nio.charset.StandardCharsets;

public class AsciiEx1 {

    public static void main(String[] args) {
//        intAscii('!');
//        getBytesAscii();

        for(int i=0; i<=255; i++)
            intToChar(i);

    }

    public static void intAscii(char c) {
        int asciiValue = c;
        System.out.println("asciiValue = " + asciiValue);
    }

    public static void getBytesAscii() {
        String s = "abcd";
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        System.out.println("bytes = " + bytes[0]);
        System.out.println("bytes = " + bytes[1]);
        System.out.println("bytes = " + bytes[2]);
        System.out.println("bytes = " + bytes[3]);
    }

    public static void intToChar(int i) {
        String s = Character.toString((char) i);
        System.out.println("s = " + s);
    }


}
