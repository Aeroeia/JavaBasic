import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SIMPLEDATEFORMAT {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        Date d = new Date();
        String s = sdf1.format(d);
        System.out.println(s);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EE");
        System.out.println(sdf2.format(d));

        //字符串转化时间
        String time = "2022-12-22 22:22:22";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 = sdf3.parse(time);
        System.out.println(d2);
    }
}
