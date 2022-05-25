package streamEx1;

import java.util.Scanner;

public class Ex1 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println(findCharCount(inputString(), inputChar()));
    }

//    private static long findCharCount(String inputString, String inputChar) {
//        String[] split = inputString.split("");
//        IntStream chars = inputString.chars();
//        Stream<String> stream = Arrays.stream(chars).filter(c -> c.equals(inputChar));
//        long count = stream.collect(Collectors.counting());
//        return count;
//    }

    private static String inputChar() {
        System.out.println("문자열 입력 : ");
        return sc.next();
    }

    public static String inputString() {
        System.out.println("문자 입력 : ");
        return sc.nextLine();
    }





}
