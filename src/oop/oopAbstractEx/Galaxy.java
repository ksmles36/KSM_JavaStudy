package oop.oopAbstractEx;

public class Galaxy extends SmartPhone{

    public Galaxy(String productName, String price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public void phoneCall() {
        System.out.println("갤럭시 전화기능으로 전화를 겁니다.");
    }

    @Override
    public void usePay() {
        System.out.println("삼성페이로 결제하겠습니다.");
    }

    @Override
    public void useCloud() {
        System.out.println("삼성 클라우드에 접속합니다.");
    }
}
