package java_Enum;

public enum EnumEx1 {

    EAST(1, "동쪽"),
    WEST(2, "서쪽"),
    SOUTH(3, "남쪽"),
    NORTH(4, "북쪽");

    private int value;
    private String direction;

    EnumEx1(int value, String direction) {
        this.value = value;
        this.direction = direction;
    }

    public int getValue() {
        return value;
    }

    public String getDirection() {
        return direction;
    }
}
