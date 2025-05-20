package HomeWork1;

public class Outer {
    public static Inter method() {
        // 使用匿名内部类实现Inter接口
        return new Inter() {
            @Override
            public void show() {
                System.out.println("HelloWorld");
            }
        };
    }

}
