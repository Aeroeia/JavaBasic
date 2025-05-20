package Graph;

import java.util.List;

public class Vertex {
    public String name;
    public List<Edge> edges;
    boolean visted = false;
    int distance = Integer.MAX_VALUE;

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }

    public Vertex(String name){
        this.name = name;
    }

}
