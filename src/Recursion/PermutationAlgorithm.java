package Recursion;

import java.util.Arrays;

//순열 알고리즘 (Permutation Algorithm)
public class PermutationAlgorithm {  

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permutation(arr, 0, 3);
    }

    public static void permutation(int[] arr, int depth, int r) {
        if (depth == r) {
            print(arr, r);
            return; //종료
        }
        for (int i=depth; i<arr.length; i++) {
            swap(arr, depth, i); //순서 변경
            permutation(arr, depth + 1, r);  //아래로 탐색
            swap(arr, depth, i);  //되돌리기
        }
    }

    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static void print(int[] arr, int r) {
        int printArr [] = arr.clone();
        if(printArr.length > r) {
            for (int i = 0; i < printArr.length; i++) {
                if (i + 1 > r) {
                    printArr[i] = -1;
                }
            }
        }
        System.out.println("Array : " + Arrays.toString(printArr));
    }

}
