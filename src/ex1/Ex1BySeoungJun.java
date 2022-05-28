package ex1;

import java.util.Scanner;

public class Ex1BySeoungJun {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputNum = sc.nextLine();

        if(inputNum.length() == 1)
            inputNum = "0" + inputNum;
        String start = inputNum;
        int count = 0;

        do {
            String[] split = inputNum.split("");

            int leftVal = Integer.parseInt(split[0]);
            int rightVal = Integer.parseInt(split[1]);

            int result = leftVal + rightVal;
            String s1 = Integer.toString(rightVal);
            String s2 = Integer.toString(result % 10);

            inputNum = s1 + s2;

            count++;

        } while (!inputNum.equals(start));

        System.out.println("count = " + count);
    }

}
