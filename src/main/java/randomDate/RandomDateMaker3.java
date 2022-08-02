package randomDate;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RandomDateMaker3 {

    public static void main(String[] args) {

        try {
            FileInputStream file = new FileInputStream("C:/Users/kim/Desktop/무통장입금 QNA_강충구_20220801.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            int rowindex=0;
            int columnindex=0;

            List<RowData> rowDataList = new ArrayList<>();
            String[] dataArr = new String[12];

            //시트 수 (첫번째에만 존재하므로 0을 준다)
            //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
            XSSFSheet sheet=workbook.getSheetAt(0);
            //행의 수
            int rows=sheet.getPhysicalNumberOfRows();
            for(rowindex=1;rowindex<rows;rowindex++){
                //행을읽는다
                XSSFRow row=sheet.getRow(rowindex);
                if(row !=null){
                    //셀의 수
                    int cells=row.getPhysicalNumberOfCells();
                    for(columnindex=0; columnindex<=cells; columnindex++){
                        //셀값을 읽는다
                        XSSFCell cell=row.getCell(columnindex);
                        String value="";
                        //셀이 빈값일경우를 위한 널체크
                        if(cell==null){
                            continue;
                        }else{
                            //타입별로 내용 읽기
                            switch (cell.getCellType()){
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    value=cell.getCellFormula();
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    value=cell.getNumericCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_STRING:
                                    value=cell.getStringCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:
                                    value=cell.getBooleanCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR:
                                    value=cell.getErrorCellValue()+"";
                                    break;
                            }
                        }
//                        System.out.println(rowindex+"번 행 : "+columnindex+"번 열 값은: "+value);
                        dataArr[columnindex] = value;
                    }
                    rowDataList.add(new RowData(dataArr));
                }
            }


            toQueryPrint(rowDataList);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void toQueryPrint(List<RowData> rowDataList) {
        for (RowData data : rowDataList) {

            String sql = String.format("insert into TBL_QNA (QNA_ID, USER_CODE, CREATE_DATE, CAT_ID, EMAIL, EMAIL_RES_YN, ITEM_ID, MOBILE_PHONE, TITLE, CONTENT,\n" +
                            "                     FILE_PATH, ANSWER, ANSWER_DATE, ADMIN_MEMO, ADMIN_ID, NAME)\n" +
                            "values (SEQ_TBL_QNA_QNA_ID.nextval,\n" +
                            "        (select max(USER_CODE) from (select USER_CODE, MOBILE_PHONE from TBL_USERINFO union all select USER_CODE, MOBILE_PHONE from TBL_DELETED_USER) where MOBILE_PHONE='%s'),\n" +
                            "        to_date('%s', 'yyyy-MM-dd HH24:MI:SS'), '%s', '%s', '%s', '%s', '%s', '%s', '%s','%s' ,'%s', to_date('%s', 'yyyy-MM-dd HH24:MI:SS'), '%s', '%s', '%s'\n" +
                            "        );"
                    , data.getMobilePhone(), data.getQnaDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")), 8, "", "N", "", data.getMobilePhone(), data.getTitle(), data.getContent()
                    , "", data.getAnswerContent(), data.getAnswerDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")), "", "admin", "");

            System.out.println(sql);
            System.out.println();
        }
    }

}
