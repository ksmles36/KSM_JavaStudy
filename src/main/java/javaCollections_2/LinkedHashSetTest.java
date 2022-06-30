package javaCollections_2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {

    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();

        hashSet.add("5");
        hashSet.add("5");
        hashSet.add("6");
        hashSet.add("7");
        hashSet.remove("6");
        hashSet.add("3");

        linkedHashSet.add("5");
        linkedHashSet.add("5");
        linkedHashSet.add("6");
        linkedHashSet.add("7");
        linkedHashSet.remove("6");
        linkedHashSet.add("3");

        hashSet.forEach(e -> System.out.println("hashSet = " + e));
        linkedHashSet.forEach(e -> System.out.println("linkedHashSet = " + e));

        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator 사용 가능 : " + iterator.next());
        }
    }
}
