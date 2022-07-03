package linuxEx220612.myMap2;

public class Main {

    public static void main(String[] args){

        MyMap myMap = new MyMap();

        myMap.put("1","aaa");
        myMap.put("2", "bbb");
        myMap.put("1","ccc");

        System.out.println(myMap.get("1"));

        myMap.replace("1" , "ggg");
        myMap.show();

    }
}
