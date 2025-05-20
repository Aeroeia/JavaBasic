package IO;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class IO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        File f = new File("JAVA28\\src\\IO\\a.txt");
//        f.createNewFile();
           properties2();
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

    //字节缓冲流
    public static void buffer() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("JAVA28\\src\\IO\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("JAVA28\\src\\IO\\aa.txt",true));
        int b;
        while((b=bis.read())!=-1){
            bos.write(b);
        }
        bos.close();
        bis.close();
    }
    //字符缓冲流
    public static void bufferchar() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("JAVA28\\src\\IO\\aa.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("JAVA28\\src\\IO\\a.txt",true));
        String str;
        while((str = br.readLine())!=null){
            System.out.println(str);
            bw.write(str);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
    //转换流
    public static void convertStream1() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("JAVA28\\src\\IO\\b.txt"),"GBK");
        int ch;
        while((ch=isr.read())!=-1){
            System.out.print((char)ch);
        }
        isr.close();
    }
    public static void converStream2() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("JAVA28\\src\\IO\\b.txt"),"GBK");
        String str = "HELLO";
        osw.write(str);
        osw.close();
    }
    //指定编码
    public static void o1() throws IOException {
        FileWriter fwr = new FileWriter("JAVA28\\src\\IO\\b.txt", Charset.forName("GBK"));
        String str = "你好";
        fwr.write(str);
        fwr.close();
    }
    public static void o2() throws IOException {
        FileReader fr = new FileReader("JAVA28\\src\\IO\\b.txt",Charset.forName("GBK"));
        char[] bt = new char[1024];
        int len;
        while((len = fr.read(bt))!=-1){
            System.out.print(new String(bt,0,len));
        }
        fr.close();
    }
    //利用转换流进行读取一整行字节
    public static void convert() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("JAVA28\\src\\IO\\a.txt")));
        String str;
        while((str = br.readLine())!=null){
            System.out.println(str);
        }
        br.close();
    }
    //序列化流
    public static void serialize() throws IOException {
        ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream("JAVA28\\src\\IO\\a.txt"));
        Person p = new Person("zhangsan",18,"广州");
        ops.writeObject(p);
        ops.close();
    }
    //反序列化流
    public static void parseserial() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("JAVA28\\src\\IO\\a.txt"));
        Person p = (Person) ois.readObject();
        System.out.println(p);
        ois.close();
    }
    //打印流
    public static void printstream() throws FileNotFoundException {
        PrintStream ps = new PrintStream(new FileOutputStream("JAVA28\\src\\IO\\aaa.txt"));
        int a = 10;
        ps.println(a);
        ps.close();
    }
    public static void printwriter() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("JAVA28\\src\\IO\\aaa.txt"),true);
        pw.println("aa");
        pw.close();

    }
    //解压缩流
    public static void depress() throws IOException {
        File src = new File("JAVA28\\src\\IO2.zip");
        File des = new File("JAVA28\\src\\IO");
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        ZipEntry entry;
        while((entry= zis.getNextEntry())!=null){
            if(entry.isDirectory()){
                File file = new File(des,entry.toString());
                file.mkdirs();
            }
            else{
                byte[] bt = new byte[1024*1024];
                int len;
                FileOutputStream fos = new FileOutputStream(new File(des,entry.toString()));
                while((len = zis.read(bt))!=-1){
                    fos.write(bt,0,len);
                }
                fos.close();
                zis.closeEntry();
            }
        }
        zis.close();
    }
    //压缩流
    public static void press() throws IOException {
        File src = new File("JAVA28\\src\\IO");
        File des = new File("JAVA28\\src\\IO2.zip");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(des));
        dopress(src,src.getName(),zos);
        zos.close();

    }
    private static void dopress(File src,String path,ZipOutputStream zos) throws IOException {
        File[] files = src.listFiles();
        if(files==null){
            return;
        }
        for(File file:files){
            if(file.isFile()){
                FileInputStream fis = new FileInputStream(file);
                ZipEntry entry = new ZipEntry(path+"\\"+file.getName());
                zos.putNextEntry(entry);
                int len;
                byte[] buffer = new byte[1024];
                while((len = fis.read(buffer))!=-1){
                    zos.write(buffer,0,len);
                }
                zos.closeEntry();;
                fis.close();
            }
            else{
                ZipEntry entry = new ZipEntry(path+"\\"+file.getName());
                zos.putNextEntry(entry);
                zos.closeEntry();
                dopress(file,path+"\\"+file.getName(),zos);
            }
        }
    }
    //common-io
    public static void iolib() throws IOException {
        File src = new File("JAVA28\\src\\IO\\a.txt");
        File des = new File("JAVA28\\src\\IO\\t.txt");
        FileUtils.copyFile(src,des);
//        FileUtils.copyDirectory();  复制文件夹
//        FileUtils.copyDirectoryToDirectory(); 复制文件夹 保留最外层文件夹
//        FileUtils.cleanDirectory(); 清空内文件
//        FileUtils.readFileToString(); 将文件数据读取为字符串
//        FileUtils.deleteDirectory(); 清空文件夹
//        FileUtils.write(); 写出数据

        //IO
//        IOUtils.copy(); 复制文件
//        IOUtils.copyLarge(); 复制大文件
//        IOUtils.readLines(); 读取数据
//        IOUtils.write(); 写出数据

    }
    //hutool
    public static void hutools(){
        //FileUtil类：
        // file:根据参数创建file对象
        //touch:根据参数创建文件
        //writelines:把集合中的数据写入文件 覆盖模式
        //readlines:指定字符编码 把文件中数据读到集合中
        //readUtf8Lines：按照UTF-8形式把文件的数据读到集合
        //copy：拷贝文件或者文件夹
    }
    //Properties Map双列集合
    public static void properties() throws IOException {
        Properties pt = new Properties();
        pt.put("aaa","111");
        pt.put("bbb","222");
        pt.put("ccc","333");
        FileOutputStream fos = new FileOutputStream("JAVA28\\src\\IO\\t.properties");
        pt.store(fos,"test");
        fos.close();
    }
    public static void properties2() throws IOException {
        Properties pt = new Properties();
        FileInputStream fis = new FileInputStream("JAVA28\\src\\IO\\t.properties");
        pt.load(fis);
        for(Map.Entry<Object,Object> entry: pt.entrySet()){
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println(key+"="+val);
        }
    }



}
