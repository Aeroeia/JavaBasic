import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args) {
        int[][] graph = {
                {0,10,0,30,100},
                {10,0,50,0,0},
                {0,50,0,20,10},
                {30,0,20,0,60},
                {100,0,10,60,0},
        };
        int n = graph.length;
        boolean[] visted = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;
        int[] previous = new int[n];
        Arrays.fill(previous,-1);
        dijkstra(graph,visted,distance,previous);
        System.out.println(Arrays.toString(distance));
        for(int i = 0;i<n;i++){
            System.out.println(getPath(i,previous));
        }

    }
    public static void dijkstra(int[][] graph,boolean[] visted,int[] distance,int[] previous){
        int n = graph.length;
        for(int i = 0;i<n;i++){
            int index = -1;
            for(int j = 0;j<n;j++){
                if(!visted[j]&&(index==-1||distance[j]<distance[index])){
                    index = j;
                }
            }
            for(int j = 0;j<n;j++){
                if(graph[index][j]!=0&&!visted[j]){
                    int temp = distance[index]+graph[index][j];
                    if(temp<distance[j]){
                        distance[j] = temp;
                        previous[j] = index;
                    }
                }
            }
            visted[index] = true;
        }
    }
    public static ArrayList<Integer> getPath(int tar,int[] previous){
        ArrayList<Integer> path = new ArrayList<>();
        for(int i = tar;i!=-1;i = previous[i]){
            path.add(0,i);
        }
        return path;
    }
}
