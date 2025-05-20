package Exception;

public class Student {
    private String name;

    public String getName() {
        return name;
    }
    public  Student(){

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        try{
            if(age<18||age>40){
                throw new RuntimeException();
            }
        }
        catch(RuntimeException e){
            this.age = 18;
        }
        if(age>=18&&age<=40){
            this.age = age;
        }
    }

    private int age;
}
