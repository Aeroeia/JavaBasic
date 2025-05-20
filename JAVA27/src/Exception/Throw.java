package Exception;

import java.util.Scanner;

public class Throw {
    public static void main(String[] args) throws RuntimeException{
        //throws 写在方法定义处 throw写在方法内 结束方法
        Scanner sc = new Scanner(System.in);
        int age;
        String name;
        while(true){
            try{
                int tage = Integer.parseInt(sc.nextLine());
                String tname  = sc.nextLine();
                if(tage<18||tage>40){
                    throw new SelfFormatException("年龄超出范围");
                }
                if(tname.length()<3||tname.length()>10){
                    throw new RuntimeException("姓名长度超出范围");
                }
                age = tage;
                name = tname;
                break;
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println(name+" "+age);

    }

}
