package java1;

import java.util.Scanner;

public class Input {

    private Scanner sc;
    private int in;

    private Input(Scanner sc) {
        inputFromUser(sc);
        forLoop();
        printResult();
    }

    private void forLoop() {
//        this.in
    }

    private void printResult() {

    }

    private void inputFromUser(Scanner sc) {
        this.in = sc.nextInt();
    }

    public static Input generate() {
        return new Input(new Scanner(System.in));
    }

    public int input() {
        return this.sc.nextInt();
    }
}
