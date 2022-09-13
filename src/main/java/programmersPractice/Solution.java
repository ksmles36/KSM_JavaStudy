package programmersPractice;

public class Solution {

    public static void main(String[] args) {
        String solution = new Solution().solution(13);
        System.out.println("solution = " + solution);
    }

    public String solution(int num) {
        String answer = "Odd";

        if(isEven(num)){
            answer = "Even";
            return answer;
        }
        return answer;
    }

    private boolean isEven(int num) {
        if(num % 2 == 0 || num == 0)
            return true;
        return false;
    }
}
