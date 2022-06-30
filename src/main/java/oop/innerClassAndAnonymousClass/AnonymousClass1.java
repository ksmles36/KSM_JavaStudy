package oop.innerClassAndAnonymousClass;

public class AnonymousClass1 {

    public static void main(String[] args) {

        SmartPhone smartPhone = new SmartPhone() {
            @Override
            public void call() {
                System.out.println("전화하기");
            }
        };

        smartPhone.call();


    }



}
