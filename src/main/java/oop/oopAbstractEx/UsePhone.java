package oop.oopAbstractEx;

public class UsePhone {

    public static void main(String[] args) {

        SmartPhone phone1 = new Iphone("아이폰 13", "130만원");
        SmartPhone phone2 = new Galaxy("갤럭시 S22", "110만원");

        System.out.println("phone1 의 제품명 : " + phone1.productName + " , 가격 : " + phone1.price);
        System.out.println("phone2 의 제품명 : " + phone2.productName + " , 가격 : " + phone2.price);

        //다형성 발생
        phone1.phoneCall();
        phone2.phoneCall();

        //다형성 발생
        phone1.usePay();
        phone2.usePay();

        //다형성 발생
        phone1.useCloud();
        phone2.useCloud();



        System.out.println();
        System.out.println("=== use2 ===");
        use2();
    }

    public static void use2() {
        //객체 인스턴스 생성
//        SmartPhone smartPhone = new Iphone("아이폰 13", "130만원");
        SmartPhone smartPhone = new Galaxy("갤럭시 22", "110만원");

        //아래는 비즈니스 로직
        smartPhone.phoneCall();
        smartPhone.usePay();
        smartPhone.useCloud();

    }
}
