package Graph;

public class Edge {
    public int weight;
    public Vertex linked;
    public Edge(int weight,Vertex linked){
        this.weight = weight;
        this.linked = linked;
    }
    public Edge(Vertex linked){
        this.linked = linked;
        this.weight = 1;
    }
}
