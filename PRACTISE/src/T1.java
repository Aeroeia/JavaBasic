import java.util.ArrayList;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        ArrayList<Integer> ary = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(sum<=200){
            String line = sc.nextLine();
            ary.add(Integer.parseInt(line));
            sum+=Integer.parseInt(line);
        }
        System.out.println(ary);
    }
}
