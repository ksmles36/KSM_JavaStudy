package javaCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableCollections {

    public static void main(String[] args) {

        List<String> originalList = new ArrayList<>();
        originalList.add("사과");
        originalList.add("바나나");
        originalList.add("딸기");

        List<String> unmodifiableList = Collections.unmodifiableList(originalList);
        printListElements(originalList, unmodifiableList);

//        unmodifiableList.add("메론");
//        unmodifiableList.remove("딸기");
//        printListElements(originalList, unmodifiableList);
        //unmodifiable 복사본은 변경하려 할 때 에러 발생

        originalList.add("귤");
        printListElements(originalList, unmodifiableList);
        //변경 불가일 것 같지만 원본은 변경 가능
    }

    private static void printListElements(List<String> originalList, List<String> unmodifiableList) {
        System.out.println();
        System.out.println();
        System.out.print("original 요소 = ");
        for (String s : originalList) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.print("unmodifiable 요소 = ");
        for (String s : unmodifiableList) {
            System.out.print(s + " ");
        }
    }

}
