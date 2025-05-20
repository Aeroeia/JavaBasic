package BigInteger_BigDecimal;

import java.math.BigDecimal;

public class BIGDECIMAL {
    public static void main(String[] args) {
        double a = 0.01;
        double b = 0.09;
        System.out.println(a+b);
        BigDecimal bd1 = new BigDecimal("0.01");
        BigDecimal bd2 = new BigDecimal("0.09");
        double bd = bd1.add(bd2).doubleValue();
        System.out.println(bd);
    }
}
