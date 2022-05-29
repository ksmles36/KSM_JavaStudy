package oop.oopAbstractEx;

public class Iphone extends SmartPhone{

    public Iphone(String productName, String price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public void phoneCall() {
        System.out.println("아이폰 전화기능으로 전화를 겁니다.");
    }

    @Override
    public void usePay() {
        System.out.println("애플페이로 결제하겠습니다.");
    }

    @Override
    public void useCloud() {
        System.out.println("애플 클라우드에 접속합니다.");
    }
}
