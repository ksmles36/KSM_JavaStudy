package linuxEx220612.myMap;

public class Main {

    public static void main(String[] args) {

        MyMap myMap = new MyMap();

        myMap.set("가", "10");
        myMap.set("나", "20");
        myMap.set("다", "30");
        myMap.set("", "40");

        myMap.show();
        System.out.println();

        String get1 = myMap.get("가");
        String get2 = myMap.get("나");
        String get3 = myMap.get("다");
        String get4 = myMap.get("라");
        String get5 = myMap.get("마");

        System.out.println("get1 = " + get1);
        System.out.println("get2 = " + get2);
        System.out.println("get3 = " + get3);
        System.out.println("get4 = " + get4);
        System.out.println("get5 = " + get5);
    }

}
