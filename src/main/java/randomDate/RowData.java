package randomDate;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Getter
public class RowData {

    private LocalDateTime chargeDate1;
    private String mobilePhone;
    private String name;
    private String chargeAmount;
    private String chargeItem;
    private LocalDateTime chargeDate2;
    private LocalDateTime qnaDate;
    private LocalDateTime answerDate;
    private String title;
    private String content;
    private String answerContent;

    public RowData(String[] dataArr) {
        this.chargeDate1 = LocalDateTime.parse(dataArr[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.mobilePhone = dataArr[1].substring(0, 11);
        this.name = dataArr[2];
        this.chargeAmount = dataArr[3];
        this.chargeItem = dataArr[4];
        this.chargeDate2 = LocalDateTime.parse(dataArr[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.qnaDate = this.chargeDate2.plusMinutes(new Random().nextInt(3)+2).plusSeconds(new Random().nextInt(58)+1);
        this.answerDate = this.qnaDate.plusMinutes(new Random().nextInt(25)+5).plusSeconds(new Random().nextInt(58)+1);
        this.title = dataArr[8];
        this.content = dataArr[10];
        this.answerContent = dataArr[11];
    }
}
