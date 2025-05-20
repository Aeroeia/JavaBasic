package FILE;

import java.io.File;
import java.io.IOException;

public class FILEDEMO {
    public static void main(String[] args) throws IOException {
        //三个构造方法
        String path = "C:\\Users\\12699\\IdeaProjects\\Java\\JAVA27\\src\\FILE\\text.txt";
        File file = new File(path);
        System.out.println(file);

        String parent = file.getParent();
        String child = file.getName();
        File file1 = new File(parent, child);
        System.out.println(file1);

        File temp = new File(file.getParent());
        File file2 = new File(temp,child);
        System.out.println(file2);

        //isDirectory 判断是否为文件夹
        File file3 = new File("C:\\Users\\12699\\IdeaProjects\\Java\\JAVA27\\src\\FILE");
        System.out.println(file3.isDirectory());

        //isFile 是否为文件
        System.out.println(file.isFile());

        //exists 判断是否存在
        File file4 = new File("C:\\Users\\12699\\IdeaProjects\\Java\\JAVA27\\src\\FILE\\a.txt");
        System.out.println(file4.exists());
        System.out.println(file4.isFile());

        //length  返回字节数 只能获取文件大小
        System.out.println(file.length());
        System.out.println(file3.length());

        //getAbsolutePath   getPath
        File file5 = new File("JAVA27\\src\\FILE\\text.txt");
        System.out.println(file5.exists());
        System.out.println(file5.getAbsolutePath());
        System.out.println(file5.getPath());

        //lastModified
        System.out.println(file.lastModified());

        //create创建文件
        File file6  = new File("JAVA27\\src\\FILE\\a.txt");
        boolean t = file6.createNewFile();

        //mkdirs创建文件夹
        File file7 = new File("JAVA27\\src\\FILE\\A\\aaa");
        System.out.println(file7.mkdirs());

        //delete
//        System.out.println(file7.delete());

        //遍历文件夹 listFiles
        File file8 = new File("JAVA27\\src\\FILE");
        File[] filelist = file8.listFiles();
        for(File f: filelist){
            System.out.println(f);
        }


    }
}
