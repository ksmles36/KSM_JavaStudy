public class Main {

    public static void main(String[] args) {
        Main main = new Main();

//        System.out.println(main.solution(626331));
        main.testEscapeString();
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

    public void testEscapeString(){
        String str1 = "rhtmdwh_1";
        System.out.println(str1);

        String str2 = str1.replace("_", "\\_");
        System.out.println(str2);

    }
}
