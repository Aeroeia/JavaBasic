package NewTimeClass;

import java.time.ZoneId;
import java.util.Set;

public class ZONEID {
    public static void main(String[] args) {
        Set<String> set = ZoneId.getAvailableZoneIds();
        ZoneId zi = ZoneId.systemDefault();
        System.out.println(zi);

    }
}
