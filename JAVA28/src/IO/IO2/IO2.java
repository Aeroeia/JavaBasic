package IO;

import java.io.*;

public class IO2 {
    public static void main(String[] args) throws IOException {
//        File f = new File("JAVA28\\src\\IO\\a.txt");
//        f.createNewFile();
       copydir(new File("JAVA28\\src\\IO"),new File("JAVA28\\src\\IO2"));
    }
    //初始化
    public static void init() throws IOException {
        FileOutputStream fos = new FileOutputStream("JAVA28\\src\\IO\\a.txt");
        fos.write('a');
        fos.close();
    }
    //换行写+续写
    public static void t1() throws IOException {
        String s = "zhengshudiyia";
        byte[] arr = s.getBytes();
        FileOutputStream fos = new FileOutputStream("JAVA28\\src\\IO\\a.txt",true);
        String wrap = "\r\n";
        byte[] wrapbyte = wrap.getBytes();
        fos.write(wrapbyte);
        fos.write(arr);
        fos.close();
    }
    //输入
    public static void t2() throws IOException {
        FileInputStream fis = new FileInputStream("JAVA28\\src\\IO\\a.txt");
        int a = fis.read();
        while(a!=-1){
            System.out.println((char)a);
            a = fis.read();
        }
        fis.close();
    }
    //文件拷贝
    public static void t3() throws IOException {
        FileOutputStream fos = new FileOutputStream("JAVA28\\src\\IO\\aa.txt");
        FileInputStream fis = new FileInputStream("JAVA28\\src\\IO\\a.txt");
        int a;
        while((a=fis.read())!=-1){
            fos.write(a);
        }
        fos.close();
        fis.close();
    }
    //文件拷贝2
    public static void t4() throws IOException {
        FileOutputStream fos = new FileOutputStream("JAVA28\\src\\IO\\aa.txt");
        FileInputStream fis = new FileInputStream("JAVA28\\src\\IO\\a.txt");
        byte[] bt= new byte[5];
        int len;
        while((len=fis.read(bt))!=-1){
                fos.write(bt,0,len);
        }
        fis.close();
        fos.close();
    }
    //字符流
    public static void charStream() throws IOException {
        FileReader fis = new FileReader("JAVA28\\src\\IO\\a.txt");
        int ch = fis.read();
        System.out.println(ch);
        System.out.println((int)'你');
        fis.close();
    }
    //字符流字符数组
    public static void charStreamArr() throws IOException {
        FileReader fr = new FileReader("JAVA28\\src\\IO\\a.txt");
        char[] chars = new char[2];
        int len;
        while((len = fr.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }
        fr.close();
    }
    //T1拷贝文件夹所有文件
    public static void copydir(File src,File des) throws IOException {
        des.mkdirs();
        File[] files = src.listFiles();
        if(files==null){
            return;
        }
        for(File file:files){
            if(file.isFile()){
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(des,file.getName()));
                byte[] bt = new byte[1024];
                int len;
                while((len=fis.read(bt))!=-1){
                    fos.write(bt,0,len);
                }
                fos.close();
                fis.close();
            }
            else{
                copydir(file,new File(des,file.getName()));
            }
        }
    }


}
