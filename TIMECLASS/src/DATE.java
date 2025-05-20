import java.util.Date;

public class DATE {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Date date2 = new Date(0L);
        System.out.println(date2);
        date2.setTime(1000L);
        System.out.println(date2);
        System.out.println(date2.getTime());
        System.out.println(date.getTime());
        long time = 1000L*60*60*24*365;
        Date date3 = new Date(time);
        System.out.println(date3);
    }
}
