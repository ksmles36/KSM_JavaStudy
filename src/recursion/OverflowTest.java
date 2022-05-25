package recursion;

public class OverflowTest {

    public static void main(String[] args) {
        function();
    }

    public static void function() {
        System.out.println("안녕하세요!");

        function();
    }
}
