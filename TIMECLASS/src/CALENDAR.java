import java.util.Calendar;

public class CALENDAR {
    public static void main(String[] args) {
        //Calendar是一个抽象类
        Calendar ca = Calendar.getInstance();
        //把时间中的信息存放到数组
        System.out.println(ca);


        //月份范围 0~11
//        Date d = new Date(0L);
//        ca.setTime(d);
//        System.out.println(ca);


        // 0：纪元 1：年 2：月 3：一年中的第几周 4：一个月中的第几周 5：一个月中的第几天
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH);
        int day  = ca.get(Calendar.DAY_OF_MONTH);
        System.out.println(year+" "+(month+1)+" "+day);

        ca.set(Calendar.YEAR, year);
        ca.add(Calendar.MONTH,+1);

    }
}
