package lotto;

import java.util.Random;
import java.util.Scanner;

public class LottoMaker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();

        for (int i = 0; i < 6; i++) {
            int num1 = new Random().nextInt(10);
            int num2 = (num1 + inputNum) % 10;

            System.out.print(num2 + " ");
        }
    }
}
