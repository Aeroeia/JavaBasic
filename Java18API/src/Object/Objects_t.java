package Object;

import java.util.Objects;

public class Objects_t {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "abc";
        boolean ret = Objects.equals(s1, s2);
        T t = null;
        System.out.println(ret);
        System.out.println(Objects.isNull(t));
        System.out.println(Objects.nonNull(new T(10)));
    }
}
