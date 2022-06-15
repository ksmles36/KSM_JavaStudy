package javaCollections_2;

import java.util.HashSet;

public class HashSetTest {

    public static void main(String[] args) {

        HashSet<Student> hashSet = new HashSet<>();

        hashSet.add(new Student("홍길동", 25));
        hashSet.add(new Student("홍길동", 25));
        hashSet.add(new Student("이순신", 30));
        hashSet.add(new Student("이순신", 30));

        hashSet.forEach(e -> System.out.println("e = " + e));

    }

}
