import java.util.*;

public class Kruskal {
    static int[] arr;
    static int[] ranks;
    public static void main(String[] args) {
        // 示例输入：顶点数=4，边数=5
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10)); // 0-1 权重10
        edges.add(new Edge(0, 2, 6));  // 0-2 权重6
        edges.add(new Edge(0, 3, 5));  // 0-3 权重5
        edges.add(new Edge(1, 3, 15)); // 1-3 权重15
        edges.add(new Edge(2, 3, 4));  // 2-3 权重4
        kruskalMST(edges, 4); // 执行算法
    }

    private static void kruskalMST(List<Edge> edges, int n) {
        arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = i;
        }
        ranks = new int[n];
        Arrays.fill(ranks,1);
        Collections.sort(edges,(o1,o2)->Integer.compare(o1.weight,o2.weight));
        List<Integer> res = new ArrayList<>();
        for(Edge edge : edges){
            int x = find(edge.src);
            int y = find(edge.des);
            if(x==y){
                continue;
            }
            union(x,y);
            res.add(edge.weight);
            if(res.size()==n-1){
                break;
            }
        }
        int sum = 0;
        for(int x : res){
            sum+=x;
        }
        System.out.println(sum);
    }

    public static int find(int x){
        if(x==arr[x]){
            return x;
        }
        return arr[x] = find(arr[x]);
    }
    public static void union(int x,int y){
        int xx = find(x);
        int yy = find(y);
        if(xx!=yy){
            if(ranks[yy]>ranks[xx]){
                arr[xx] = yy;
            }
            else{
                arr[yy] = xx;
                if(ranks[yy]==ranks[xx]){
                    ranks[xx]++;
                }
            }
        }
    }
}
class Edge{
    int src;
    int des;
    int weight;
    public Edge(int src,int des,int weight){
        this.src = src;
        this.des = des;
        this.weight = weight;
    }
}