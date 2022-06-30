package oop.innerClassAndAnonymousClass;

public class InnerClassEx2 {

    public static void main(String[] args) {

        InnerClassEx1 innerClassEx1 = new InnerClassEx1();
        InnerClassEx1.InnerClass1 innerClass1 = innerClassEx1.new InnerClass1();

        innerClass1.method1();


        InnerClassEx1.InnerStaticClass innerStaticClass = new InnerClassEx1.InnerStaticClass();
        innerStaticClass.method2();

    }

}
