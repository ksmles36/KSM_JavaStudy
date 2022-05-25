package recursion;

public class Recursion3 {

    public static void main(String[] args) {
        System.out.println(addToR(10));
    }

    public static int addToR(int num) {
        if (num < 2) {
            return 1;
        }else{
            return num + addToR(num-1);
        }
    }
}
