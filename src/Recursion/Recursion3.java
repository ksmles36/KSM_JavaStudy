package Recursion;

public class Recursion3 {

    public static void main(String[] args) {
        addToR(10);
    }

    public static int addToR(int num) {
        if (num == (num-1)) {

            return num;
        }else{
            return addToR(num);
        }
    }
}
