package 正则表达式;

public class GROUP {
    public static void main(String[] args) {
        //判断开始部分与结束部分是否一致

        // \\组号表示把x组的内容取出
        String s1 = "a123a";
        String regex1 = "(.).+\\1";
        System.out.println(s1.matches(regex1));

        //判断开始部分和结束部分是否一致，可以有多个字符
        String regex2 = "(.+).+\\1";
        String s2 = "abc123abc";
        System.out.println(s2.matches(regex2));


        //判断开始位置与结束位置字符是否一致，且内部内容相同
        String regex3 = "((.)\\2*).+\\1";
        String s3 = "aaa123aaa";
        System.out.println(s3.matches(regex3));


        // $外部使用
        String str = "我要学学学编编编编程程程程程";
        str = str.replaceAll("(.)\\1+","$1");
        System.out.println(str);

        //非捕获分组： ?:  仅仅表示括起来 不占用组位 (?:....)

    }
}
