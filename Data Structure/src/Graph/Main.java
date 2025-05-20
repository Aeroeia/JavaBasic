package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static List<Vertex> path = new ArrayList<>();
    public static List<List<Vertex>> res = new ArrayList<>();
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(new Edge(14,v6),new Edge(7,v2),new Edge(9,v3));
        v2.edges = List.of(new Edge(15,v4));
        v3.edges = List.of(new Edge(2,v6),new Edge(11,v4));
        v4.edges = List.of(new Edge(6,v5));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(9,v5));

        dijkstra(v1);

    }
    public static void dijkstra(Vertex root){
        root.distance = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1.distance,o2.distance));
        queue.offer(root);
        while(!queue.isEmpty()){
            Vertex v = queue.poll();
            if(v.visted){
                continue;
            }
            v.visted = true;
            System.out.println(v.name+" "+v.distance);
            for(Edge edge :v.edges){
                int distance = v.distance+edge.weight;
                if(!edge.linked.visted&&distance<edge.linked.distance){
                    edge.linked.distance = distance;
                    queue.offer(edge.linked);
                }
            }
        }

    }
    public static void dfs(Vertex root){
        if(root.edges.size()==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(Edge e:root.edges){
            path.add(e.linked);
            dfs(e.linked);
            path.remove(path.size()-1);
        }
    }
    public static void bfs(Vertex root){
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Vertex v = queue.poll();
            System.out.println(v);
            for(Edge edge :v.edges){
                if(!edge.linked.visted){
                    queue.offer(edge.linked);
                    edge.linked.visted = true;
                }
            }
        }
    }
}
