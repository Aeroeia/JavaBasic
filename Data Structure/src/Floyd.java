import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd {
    static int INF = Integer.MAX_VALUE>>2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pt = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];
        for(int[] arr:graph){
            Arrays.fill(arr,INF);
        }
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        int[][] dis = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i==j){
                    dis[i][j] = 0;
                }
                else{
                    dis[i][j] = graph[i][j];
                }
            }
        }
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    dis[i][j] = Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }
        long res = 0;
        for(int i = 0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken())-1;
            int times = Integer.parseInt(st.nextToken());
            for(int x : dis[index]){
                if(x<=times){
                    res++;
                }
            }
        }
        pt.printf("%.2f",res/(double)q);
        pt.flush();
        pt.close();
    }
}
