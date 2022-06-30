package recursion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilePathNavigation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputRoute = sc.nextLine();

        File file = new File(inputRoute);

        List<String> stringList = new ArrayList<>();

        loop(inputRoute, file, stringList);

        for (String s : stringList) {
            System.out.println("폴더이름 = " + s);
        }

    }

    private static void loop(String inputRoute, File file, List<String> stringList) {
        for (String name : file.list()) {
            File fileOne = getRoute(inputRoute, name);

            if (fileOne.isDirectory()) {
//                System.out.println("폴더입니다 : " + name);
                stringList.add(name);
//                System.out.println("다음 폴더로 진입합니다. : " + fileOne.toString());
                loop(fileOne.toString(), fileOne, stringList);
            }
            System.out.println("파일입니다 : " + name);
        }
    }

    private static File getRoute(String inputRoute, String name) {
        return new File(inputRoute + File.separator + name);
    }
}
