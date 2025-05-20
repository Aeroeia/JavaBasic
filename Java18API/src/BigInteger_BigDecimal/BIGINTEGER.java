package BigInteger_BigDecimal;

import java.math.BigInteger;
import java.util.Random;

public class BIGINTEGER {
    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger(4,new Random());//随机获取0~2^4-1间的数字
        System.out.println(bi1);
        BigInteger bi2 = new BigInteger("99999999999999999999999999999");
        System.out.println(bi2);
        BigInteger bi3 = new BigInteger("100",2);//二进制中的100 4
        System.out.println(bi3);
        System.out.println(BigInteger.valueOf(1000));//long类型范围内


        //内部进行优化 -16~16间对象不重新创建
        BigInteger bi4 = BigInteger.valueOf(16);
        BigInteger bi5 = BigInteger.valueOf(16);
        System.out.println(bi4==bi5);

        System.out.println(bi1.add(bi3));
        System.out.println(Integer.MAX_VALUE);
    }
}
