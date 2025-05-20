import java.util.Scanner;

public class fastpower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int power = sc.nextInt();
        int res = 1;
        while(power>0){
            if(power%2==0){
                base*=base%1000;
                power/=2;
            }
            else{
                res*=base%1000;
                power--;
                base*=base%1000;
                power/=2;
            }
        }
        System.out.println(res);
    }
}