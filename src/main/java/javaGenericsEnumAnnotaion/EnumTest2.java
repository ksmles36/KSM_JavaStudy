package javaGenericsEnumAnnotaion;

public class EnumTest2 {

    public static void main(String[] args) {
    }

}

enum Fruit2 {
    MANGO("망고"), PEAR("배"), PEACH("복숭아"), ORANGE("오렌지");

    private String name;

    Fruit2(String name) {
        this.name = name;
    }
}
