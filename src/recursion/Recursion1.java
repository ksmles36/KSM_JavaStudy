package recursion;

public class Recursion1 {

    public static void main(String[] args) {
        System.out.println("normalSums : "+normalSums(1));
    }

    public static int normalSums(int arg) {
        System.out.println("in :  "+arg);
        if(arg > 5) {
            System.out.println("end : "+arg);
            return arg;
        } else {
            System.out.println("out : "+arg);
        }
        return normalSums(arg+1);
    }

}
