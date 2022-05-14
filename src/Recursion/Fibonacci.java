package Recursion;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxCount = sc.nextInt();

        int[] arr = new int[maxCount];
        arr[0] = 1;
        arr[1] = 1;

        System.out.print("runUseForLoop : ");
        System.out.print(String.format("%d %d ", arr[0], arr[1]));
        runUseForLoop(arr, maxCount);

        System.out.println();

        System.out.print("runUseRecursion : ");
        System.out.print(String.format("%d %d ", arr[0], arr[1]));
        runUseRecursion(arr, maxCount, 2);
    }

    private static void runUseRecursion(int[] arr, int maxCount, int i) {
        if (i >= maxCount) {
            return;
        }

        arr[i] = arr[i-2] + arr[i-1];
        System.out.print(String.format("%d ", arr[i]));
        runUseRecursion(arr, maxCount, ++i);
    }

    private static void runUseForLoop(int[] arr, int maxCount) {
        for (int i = 2; i < maxCount; i++) {
            arr[i] = arr[i-2] + arr[i-1];
            System.out.print(String.format("%d ", arr[i]));
        }
    }


}
