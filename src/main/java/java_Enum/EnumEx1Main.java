package java_Enum;

public class EnumEx1Main {

    public static void main(String[] args) {

        System.out.println(EnumEx1.EAST.getDirection());

        for (EnumEx1 e : EnumEx1.values()) {
            System.out.println(e.getDirection());
        }

        System.out.println(EnumEx1.WEST.name());
        System.out.println(EnumEx1.SOUTH.ordinal());
        System.out.println(EnumEx1.valueOf("NORTH"));

    }

}
