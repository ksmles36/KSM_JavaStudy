package javaCollections_2;

import java.util.*;

public class LinkedHashSetTest2 {

    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet();

        listAdd(hashSet, linkedHashSet);

        System.out.println("hashSet");
        printFor(hashSet);
        System.out.println();
        System.out.println("linkedHashSet");
        printFor(linkedHashSet);

        System.out.println();

        System.out.println("hashSet");
        printIterator(hashSet);
        System.out.println();
        System.out.println("linkedHashSet");
        printIterator(linkedHashSet);

    }

    private static void printIterator(Set set) {
        long beforeTime = System.currentTimeMillis();

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " " );
        }

        System.out.println();
        long afterTime = System.currentTimeMillis();
        System.out.println("set의 사이즈 : " + set.size());
        System.out.println("printFor : " + (afterTime - beforeTime)+"ms 소요됨");
    }

    private static void printFor(Set<Integer> set) {
        long beforeTime = System.currentTimeMillis();
        
        for (int i : set) {
            System.out.print(i + " ");
        }

        System.out.println();
        long afterTime = System.currentTimeMillis();
        System.out.println("set의 사이즈 : " + set.size());
        System.out.println("printFor : " + (afterTime - beforeTime)+"ms 소요됨");
    }

    private static void listAdd(Set set1, Set set2) {
        for (int i = 0; i < 10000; i++) {
            int random = new Random().nextInt(9999999);
            set1.add(random);
            set2.add(random);
        }
    }
}
