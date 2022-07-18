package javaGenericsEnumAnnotaion;

public class EnumTest1 {

    private int num1;
    private int num2;
    private int num3;
    private enum Fruit{
        MANGO("망고"), PEAR("배"), PEACH("복숭아"), ORANGE("오렌지");

        private String name;

        Fruit(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

    }

}
