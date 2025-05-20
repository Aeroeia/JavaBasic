package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REGEX {
    public static void main(String[] args) {
        //6位至20位
        //不能以0开头
        //全部是数字
        String qq = "123412345";
        System.out.println(qq.matches("[\\d&&[^0]]\\d{5,19}"));

        String str ="Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，"+
                "因为这两个是长期支持版本，下一个长期支持版本是java17，相信在未来不久Java17也会逐渐登上历史舞台";

//        Pattern pat = Pattern.compile("Java\\d{0,2}");
//        Matcher mat = pat.matcher(str);
        //demo(pat, str);

//        String s = match(mat);
//        System.out.println(s);
        //Myversion(str);

        //?理解为前面的Java
        //=表示后面要跟随的数据
        //爬取的时候只获取前面部分
        //(?i)忽略大小写
        String regex1 = "(?i)Java(?!8|11|17)";
        String regex2 = "(?i)Java(?=8|11|17)";  //数据不会被提取出来
        String regex3 = "(?i)Java(?:8|11|17)";  //数据会被提取出来

        Matcher m = Pattern.compile(regex3).matcher(str);

        while(m.find()){
            System.out.println(m.group());
        }



    }

    private static void Myversion(String str) {
        Matcher mat = Pattern.compile("Java\\d{1,2}").matcher(str);
        while(mat.find()) {
            Matcher m = Pattern.compile("Java").matcher(mat.group());
            m.find();
            System.out.println(m.group());
        }
    }

    private static void demo(Matcher mat, String str) {
        System.out.println(mat.find());
        String s = mat.group();
        System.out.println(s);

        //后面调用find 继续读取后面内容  find记录索引
        System.out.println(mat.find());
        System.out.println(mat.group());
    }
    private static String match(Matcher mat) {
        StringBuilder sb = new StringBuilder();
        while(mat.find()){
            sb.append(mat.group());
            sb.append(" ");
        }
        return sb.toString();
    }
}
