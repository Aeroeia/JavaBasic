package System;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSystem {
   public static void startSystem(){
       Scanner set = new Scanner(System.in);
         int input = 0;
       ArrayList<Student> stu = new ArrayList<>();
       loop:while(true){
           menu();
           input = set.nextInt();
          switch (input){
              case 1->add(stu);
              case 2->delete(stu);
              case 3->update(stu);
              case 4->query(stu);
              case 5->{
                  System.out.println("退出");
                  break loop;
                  //System.exit(0);停止虚拟机运行
              }

              default -> System.out.println("输入错误");
          }
       }


   }
   //菜单
   public static void menu(){
       System.out.println("--------欢迎来到管理系统----------");
       System.out.println("1:添加学生");
       System.out.println("2:删除学生");
       System.out.println("3:修改学生");
       System.out.println("4:查询学生");
       System.out.println("5:退出");
       System.out.println("请输入你的选择:");
   }
   //添加
   public static void add(ArrayList<Student> stu) {
       Scanner set = new Scanner(System.in);
       Student s = new Student();
       long id = 0;
       while(true){
           System.out.println("print id");
           id = set.nextLong();
           if(checkId(stu,id)){
               System.out.println("该学生id已存在，请重新输入");
           }
           else{
               s.setId(id);
               break;
           }
       }
       System.out.println("print name");
       s.setName(set.next());
       System.out.println("print age");
       s.setAge(set.nextInt());
       System.out.println("print address");
       s.setAddress(set.next());
       if (stu.add(s)) {
           System.out.println("添加成功");
       } else {
           System.out.println("添加失败");
       }
   }
   //删除
   public static void delete(ArrayList<Student> stu){
       if(stu.size() == 0){
           System.out.println("无学生信息");
           return;
       }
       Scanner set = new Scanner(System.in);
       System.out.println("输入要删除学生的id");
       long id = set.nextLong();
       if(checkId(stu,id)){
           stu.remove(getIndex(stu,id));
           System.out.println("删除成功");
       }
       else{
           System.out.println("没有该学生信息");
       }
   }
   //修改
   public static void update(ArrayList<Student> stu){
       if(stu.size() == 0){
           System.out.println("无学生信息");
           return;
       }
       Scanner set = new Scanner(System.in);
       while(true){
           System.out.println("输入要修改学生的id");
           long id = set.nextLong();
           if(checkId(stu,id)){
               Student s = new Student();
               s.setId(id);
               System.out.println("print name");
               s.setName(set.next());
               System.out.println("print age");
               s.setAge(set.nextInt());
               System.out.println("print address");
               s.setAddress(set.next());
               stu.set(getIndex(stu,id),s);
               break;
           }
           else{
               System.out.println("该学生信息不存在");
               break;
           }
       }
   }
   //查询
   public static void query(ArrayList<Student> stu){

       if(stu.size() == 0){
           System.out.println("当前无学生信息");
           return;
       }
       else{
           System.out.println("id\t\t姓名\t年龄\t家庭住址");
           for (int i = 0; i < stu.size(); i++) {
               System.out.print(stu.get(i).getId()+"\t"+stu.get(i).getName()+"\t"+stu.get(i).getAge()+"\t"+stu.get(i).getAddress());
               System.out.println();
           }
       }
   }
   //判断是否存在
   public static boolean checkId(ArrayList<Student> stu, long id){
      return getIndex(stu,id) >= 0;
   }
   //获取索引
    public static int getIndex(ArrayList<Student> stu, long id){
        for (int i = 0; i < stu.size(); i++) {
            if(stu.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

}
