package FILE;

import java.io.File;
import java.io.IOException;

public class T {
    public static void main(String[] args) throws IOException {
        //T1
//        File f = new File("JAVA27\\src\\FILE\\aaa");
//        System.out.println(f.mkdirs());
//        File f2 = new File(f,"a.txt");
//        System.out.println(f2.createNewFile());

        //T2
//        File root = new File("JAVA27\\\\src\\\\FILE\\aaa");
//        File[] flist = root.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File file) {
//                return file.toString().endsWith("txt");
//            }
//        });
//        if(flist.length>0){
//            System.out.println("YES");
//        }
//        else{
//            System.out.println("NO");
//        }

        //T3
//        File root = new File("C:\\");
//        dfs(root);

        //T4
//        File f = new File("JAVA27\\src\\FILE\\a\\aa\\aaa\\aaaa");
//        File file = new File(f,"a.txt");
//        File root = new File("JAVA27\\src\\FILE\\a");
////        System.out.println(f.mkdirs());
////        System.out.println(file.createNewFile());
//        delete(root);

        //T5
         File root = new File("JAVA27");
        System.out.println(count(root));

    }
    public static void dfs(File root){
        File[] flist = root.listFiles();
        if(flist==null){
            return;
        }
        for(File file: flist){
            if(file.isFile()){
                if(file.getName().endsWith("txt")){
                    System.out.println(file.getPath());
                }
            }
            else{
                dfs(file);
            }
        }
    }
    public static void delete(File root){
        File[] flist = root.listFiles();
        if(flist==null){
            return;
        }
        for(File f:flist) {
            if (f.isFile()) {
                f.delete();
            } else {
                delete(f);
            }
        }
        root.delete();
    }
    public static long count(File root){
        File[] flist = root.listFiles();
        if(flist==null){
            return 0;
        }
        long len = 0;
        for(File f : flist){
            if(f.isFile()){
                len+=f.length();
            }
            else{
                len+=count(f);
            }
        }
        return len;
    }
}

