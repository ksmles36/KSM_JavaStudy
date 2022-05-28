package recursion;

import java.io.File;
import java.util.Scanner;

public class FilePathNavigation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputRoute = sc.nextLine();

        File file = new File(inputRoute);

        loop(inputRoute, file.list());
    }

    private static void loop(String inputRoute, String[] list) {
        for (String name : list) {
            File file = getRoute(inputRoute, name);

            if (file.isDirectory()) {
                System.out.println("폴더입니다 : " + name);
                System.out.println("다음 폴더로 진입합니다. : " + file.toString());
                loop(file.toString(), file.list());
            }
            System.out.println("파일입니다 : " + name);
        }
    }

    private static File getRoute(String inputRoute, String name) {
        return new File(inputRoute + File.separator + name);
    }

}
