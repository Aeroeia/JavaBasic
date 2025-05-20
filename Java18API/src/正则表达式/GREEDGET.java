package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GREEDGET {
    public static void main(String[] args) {
        String str ="Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11,aaaaabbbbbbbbbbbbbbaa"+
                "因为这两个是长期支持版本，下一个长期支持版本是java17，相信在未来不久Java17也会逐渐登上历史舞台";
        //默认贪婪爬取
        String regex1 = "ab+";
        String regex2 = "ab+?";
        Matcher m1 = Pattern.compile(regex1).matcher(str);
        m1.find();
        System.out.println(m1.group());

        //非贪婪爬取
        Matcher m2 = Pattern.compile(regex2).matcher(str);
        m2.find();
        System.out.println(m2.group());


    }
}
