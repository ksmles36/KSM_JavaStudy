package javaCollections;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetEx1 {

    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet<Integer>();  //제네릭을 이용하여 구성될 데이터 타입을 지정해줄 수 있다
        Random random = new Random();

        for (int j = 0; j < 5; j++) {
            makeTreeSet(treeSet, random);
        }


        System.out.println();
        findNumber(treeSet, 5, 15);
    }

    public static void makeTreeSet(TreeSet treeSet, Random random) {
        for (int i = 0; i < 10; i++) {
            int ranNum = random.nextInt(20);
            treeSet.add(ranNum);  //TreeSet에 추가 add
        }
        System.out.println(treeSet.toString() + " Size : " + treeSet.size());  //toString, 사이즈 구하기
        treeSet.clear();  //TreeSet 내부 데이터 비우기
    }

    private static void findNumber(TreeSet treeSet, int num1, int num2) {
        for (int i = 0; i < 10; i++) {
            int ranNum = new Random().nextInt(20);
            treeSet.add(ranNum);
        }
        System.out.println("treeSet = " + treeSet);

        SortedSet subSetResult = treeSet.subSet(num1, num2);  //subSet 으로 범위에 해당되는 값들만 뽑아내기
        System.out.println("subSetResult = " + subSetResult);
    }

}
