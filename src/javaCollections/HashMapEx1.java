package javaCollections;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx1 {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("자바", 90);
        map.put("데이터베이스", 85);
        map.put("네트워크", 80);
        map.put("자료구조", 70);
        map.put("운영체제", 60);

        System.out.println("map = " + map.toString());

        duplicateEx(map);
        removeEx(map);
        foreachEx(map);
    }

    private static void duplicateEx(HashMap<String, Integer> map) {
        System.out.println();

        map.put("자바", 95);
        System.out.println("duplicateEx map = " + map);
        //중복하여 값을 넣으면 덮어씌우게 된다.

        if (!map.containsKey("데이터베이스")) {
            map.put("데이터베이스", 50);
        }
        //if문으로 키값이 기존에 있는지 체크하여 값을 선택적으로 넣을 수 있음
    }

    private static void removeEx(HashMap<String, Integer> map) {
        System.out.println();

        map.remove("자료구조");
        System.out.println("removeEx map = " + map);
        System.out.println("removeEx " + map.remove("자료구조"));
        //키 값으로 키, 밸유 삭제 가능
        //삭제하려는 키 값이 없다면 null을 반환한다
    }

    private static void foreachEx(HashMap<String, Integer> map) {
        System.out.println();

        System.out.print("foreachEx ");
        map.forEach((k, v) -> {
            System.out.print(k + " ");
            System.out.print(v + "점 ");
        });
        //forEach 메소드를 사용하여 람다식을 활용해서 map내부를 순회하며 작업 가능
    }
}
