package Recursion;

import java.util.Scanner;

public class Recursion4 {
    //구구단을 재귀함수를 사용하여 만들기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dan = sc.nextLine();
        runUseRecursion(dan, 1);
    }

    private static void runUseRecursion(String strDan, int i) {
        int dan = Integer.parseInt(strDan);

        if (i > 9) {
            return;
        }else{
            System.out.println(String.format("%d * %d = %d", dan, i, dan * i));
            runUseRecursion(strDan, ++i);
        }
    }


}
