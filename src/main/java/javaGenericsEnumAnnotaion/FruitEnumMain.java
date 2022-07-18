package javaGenericsEnumAnnotaion;

public class FruitEnumMain {

    public static void main(String[] args) {

//        System.out.println(Fruit.getTotalPrice(Fruit.APPLE, 5));

        Fruit apple1 = Fruit.APPLE;
        Fruit apple2 = Fruit.APPLE;
        Fruit apple3 = Fruit.APPLE;

        System.out.println(apple1.hashCode());
        System.out.println(apple2.hashCode());
        System.out.println(apple3.hashCode());

        System.out.println(apple1.equals(apple2));
        System.out.println(apple2.equals(apple3));

    }

}
