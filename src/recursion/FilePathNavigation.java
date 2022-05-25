package recursion;

import java.io.File;

public class FilePathNavigation {

    public static void main(String[] args) {

//        String path = System.getProperty("user.dir");
//        File file = new File(path);
//        String[] strings = file.list();
//        for (String str : strings) {
//            System.out.println("str = " + str);
//        }

//        String filePath = "../ProgramFiles";
//        File dir = new File(filePath);
//        String path = dir.getPath();
//        System.out.println("path = " + path);

        File dir = new File("C:");
        File files[] = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            System.out.println("file: " + files[i]);
        }




    }

}
