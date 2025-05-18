import java.util.*;
class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(V data) {
        if (!vertices.containsKey(data)) {
            vertices.put(data, new Vertex<>(data));
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Set<Vertex<V>> getVertices() {
        return new HashSet<>(vertices.values());
    }

    public void addEdge(V sourceData, V destData, double weight) {
        Vertex<V> source = vertices.get(sourceData);
        Vertex<V> destination = vertices.get(destData);

        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source or destination vertex not found in the graph");
        }

        source.addAdjacentVertex(destination, weight);
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        source.addAdjacentVertex(destination, weight);
    }

    public void printGraph() {
        for (Vertex<V> vertex : vertices.values()) {
            System.out.print(vertex + " -> ");
            for (Map.Entry<Vertex<V>, Double> adjacentVertex : vertex.getAdjacentVertices().entrySet()) {
                System.out.print(adjacentVertex.getKey() + "(" + adjacentVertex.getValue() + ") ");
            }
            System.out.println();
        }
    }
}