public class T3 {
    static double res = 1;
    public static void main(String[] args) {
        getSum(10);
        System.out.println(res);
    }
    public static void getSum(int n){
        if(n==1){
            return;
        }
        res = (res+1)*2;
        getSum(n-1);

    }

}
