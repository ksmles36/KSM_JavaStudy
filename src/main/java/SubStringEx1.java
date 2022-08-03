public class SubStringEx1 {

    public static void main(String[] args) {

//        String str = "Content-Disposition: form-data; name=\"oExcelFile\"; filename=\"standardAddress.xls\"";
//        System.out.println(str);
//
//        int index = str.indexOf("filename=");
//
//        String substring = str.substring(index+10);
//        String replace = substring.replace("\"", "");
//        System.out.println(replace);


//        String fileName = "standardAddress.xlsqw";
//        String substring = fileName.substring(fileName.length() - 5, fileName.length()-2);
//        System.out.println(substring);


        String file = "adasdasdasd.xlsx";
        String substring = file.substring(file.length()-4, file.length());
        System.out.println(substring);


    }

}
