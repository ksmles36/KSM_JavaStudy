package javaGenericsEnumAnnotaion;

public enum Fruit {

    APPLE(1000, "사과"),
    BANANA(2000, "바나나"),
    GRAPE(3000, "포도"),
    MELON(4000, "멜론");

    private int price;
    private String name;

    Fruit(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static int getTotalPrice(Fruit fruit, int amount) {
        return fruit.price* amount;
    }

}
