package Recursion;

public class Recursion2 {

    public static void main(String[] args) {
        System.out.println("otherSums : "+otherSums(1));
    }

    public static int otherSums(int arg) {
        int res = 0;
        System.out.println("in :  "+arg);

        if(arg > 5) {
            System.out.println("end : "+arg);
            return arg;
        } else {
            res = otherSums(arg+1);
        }

        System.out.println("out : "+arg);
        return res;
    }
}
