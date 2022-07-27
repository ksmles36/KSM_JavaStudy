package randomDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RowDate {

    LocalDateTime chargeDate;
    LocalDateTime qnaDate;
    LocalDateTime answerDate;

    public RowDate(String date) {
        this.chargeDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        qnaDate = this.chargeDate.plusMinutes(new Random().nextInt(30)+10).plusSeconds(new Random().nextInt(30)+10);
        answerDate = this.qnaDate.plusMinutes(new Random().nextInt(30)+10).plusSeconds(new Random().nextInt(30)+10);
    }
}
