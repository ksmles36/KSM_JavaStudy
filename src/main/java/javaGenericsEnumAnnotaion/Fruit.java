package javaGenericsEnumAnnotaion;

public enum Fruit {
    APPLE,
    BANANA,
    GRAPE;

    Fruit() {
        System.out.println("생성자 호출! " + this);
    }
}
