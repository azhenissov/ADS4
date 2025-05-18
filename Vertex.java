import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<V>{
    private V data;
    private Map<Vertex<V>, Double> adjacenctVertices;

    public Vertex(V data){
        this.data = data;
        this.adjacenctVertices = new HashMap<>();
    }

    public V getData(){
        return data;
    }

    public void setData(V data){
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjacenctVertices(){
        return adjacenctVertices;
    }

    public void addAdjacentVertex(Vertex<V> destination, Double weight){
        adjacenctVertices.put(destination, weight);
    }

    @Override
    public String toString(){
        return data.toString();
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }
    @Override
    public int hashCode(){
        return Objects.hash(data);
    }
}
