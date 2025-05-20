package NewTimeClass;

import java.time.Instant;

public class INSTANT {
    public static void main(String[] args) {
        Instant ins = Instant.now();
        System.out.println(ins);

        Instant ins1 = Instant.ofEpochMilli(0L); //时间原点过了多久
        System.out.println(ins1);


    }
}
