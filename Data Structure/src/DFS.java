import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static List<Integer> path = new ArrayList<Integer>();
    public static List<List<Integer>> ret = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(nthPersonGetsNthSeat(5));
    }
    public static double nthPersonGetsNthSeat(int n) {
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = i+1;
        }
        boolean[] used = new boolean[n];
        for(int i = 0;i<n-1;i++){
            dfs(arr,used,i);
        }
        int count = 0;
        for(int i = 0;i<ret.size();i++){
            List<Integer> l = ret.get(i);
            if(l.get(l.size()-1)==n){
                count++;
            }
        }
        double p = (double)count/ret.size();
        return p;
    }
    public static void dfs(int[] arr,boolean[] used,int index){
        if(path.size()==arr.length){
            return;
        }
        path.add(arr[index]);
        used[index] = true;
        for(int i =0;i<arr.length;i++){
            if(!used[i])
                dfs(arr,used,i);
        }
        if(path.size()==arr.length){
            ret.add(new ArrayList<Integer>(path));
        }
        path.remove(path.size()-1);
        used[index] =false;
    }
}
