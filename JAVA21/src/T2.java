import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        //不死神兔
        System.out.println(rabbit(2));
        int prevfir = 1;
        int prevsec = 1;
        int ret = 0;
        Scanner sc = new Scanner(System.in);
        for(int i = sc.nextInt();i>2;i--){
            ret = prevfir+ prevsec;
            prevfir = prevsec;
            prevsec = ret;
        }
        System.out.println(ret);
    }
    public static int rabbit(int n){
        if(n==1||n==2){
            return 1;
        }
        int prevfir = rabbit(n-2);
        int prevsec = rabbit(n-1);
        return prevfir+prevsec;
    }
}
