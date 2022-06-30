public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(main.solution(626331));
    }

    public int solution(int num) {
        int count = 0;
        int result = -1;

        for (int i = 0; i < 501; i++) {
            if (num % 2 == 0) {
                num = num / 2;
                count++;
            } else {
                num = num * 3 + 1;
                count++;
            }
            if(num == 1)
                break;
//            if (i == 500) {
//                count = -1;
//                break;
//            }
            result = count;
        }

        int answer = result;
        return answer;
    }
}
