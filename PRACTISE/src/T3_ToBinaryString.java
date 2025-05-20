import java.util.Scanner;

public class T3_ToBinaryString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.parseInt(line);
        System.out.println(toBinaryString(n));

    }
    public static String toBinaryString(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.insert(0, n%2);
            n/=2;
        }
        return sb.toString();
    }
}
