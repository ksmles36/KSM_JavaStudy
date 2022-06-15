package javaCollections_2;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {

    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();

        hashSet.add("3");
        hashSet.add("3");
        hashSet.add("2");
        hashSet.add("1");
        hashSet.remove("2");
        hashSet.add("4");

        linkedHashSet.add("3");
        linkedHashSet.add("3");
        linkedHashSet.add("2");
        linkedHashSet.add("1");
        linkedHashSet.remove("2");
        linkedHashSet.add("4");

        hashSet.forEach(e -> System.out.println("hashSet = " + e));
        linkedHashSet.forEach(e -> System.out.println("linkedHashSet = " + e));
    }
}
