package Math;

import java.util.ArrayList;
import java.util.List;

public class T {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
    }
    public static boolean isPrime(int n ){
        for(int i = 2 ;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
