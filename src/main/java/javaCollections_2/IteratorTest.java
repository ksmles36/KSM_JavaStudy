package javaCollections_2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


public class IteratorTest {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        listAdd(list);

        searchFor(list);

        searchIterator(list);
    }

    public static void searchFor(LinkedList linkedList) {
        long beforeTime = System.currentTimeMillis();

        for (int i = 0; i < linkedList.size(); i++) {
            int e = (int)linkedList.get(i);
            System.out.print(e + " ");
        }

        System.out.println();
        long afterTime = System.currentTimeMillis();
        System.out.println("searchFor : " + (afterTime - beforeTime)+"ms 소요됨");
    }

    public static void searchIterator(LinkedList linkedList) {
        long beforeTime = System.currentTimeMillis();

        System.out.println();
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            int e = (int)iterator.next();
            System.out.print(e + " ");
        }

        System.out.println();
        long afterTime = System.currentTimeMillis();
        System.out.println("searchIterator : " + (afterTime - beforeTime)+"ms 소요됨");
    }

    public static void listAdd(LinkedList linkedList) {
        for (int i = 0; i < 10000; i++) {
            linkedList.add(new Random().nextInt(100));
        }
    }

}
