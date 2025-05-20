import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CalculateTime {
    public static void main(String[] args) throws ParseException {
        System.out.println(J7GetTime()/1000/60/60/24/365);
        System.out.println(J8GetTime());

    }
    public static long J7GetTime() throws ParseException {
        String birthday = "2004-04-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birthday);
        long birthdaytime = date.getTime();
        long curr = System.currentTimeMillis();
        return curr-birthdaytime;
    }
    public static long J8GetTime(){
        LocalDate ld1 = LocalDate.of(2004,4,8);
        LocalDate ld2 = LocalDate.now();
        long day = ChronoUnit.DAYS.between(ld1,ld2);
        return day;
    }
}
