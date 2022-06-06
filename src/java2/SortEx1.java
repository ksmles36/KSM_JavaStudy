package java2;

import java.util.Random;

public class SortEx1 {

    public static void main(String[] args) {

        int[] arr100 = new int[100];

        for (int i = 0; i < 100; i++)
            arr100[i] = new Random().nextInt(89999) + 10000;

        int[] sortedArr = sortArr(arr100);

        for (int i : sortedArr)
            System.out.println("i = " + i);
    }

    private static int[] sortArr(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                if (arr[i] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        return arr;
    }

}
