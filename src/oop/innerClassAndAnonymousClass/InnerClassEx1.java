package oop.innerClassAndAnonymousClass;

public class InnerClassEx1 {

    public class InnerClass1{

        void method1() {

        }
    }

    public static class InnerStaticClass{
        void method2() {
        }
    }

    public void method() {

        class LocalInnerClass{

        }

        LocalInnerClass localInnerClass = new LocalInnerClass();
    }

}
