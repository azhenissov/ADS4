import java.util.*;
abstract class Search<V> {
    protected WeightedGraph<V> graph;
    protected Vertex<V> source;
    protected Map<Vertex<V>, Double> distances;
    protected Map<Vertex<V>, Vertex<V>> predecessors;
    protected Set<Vertex<V>> visited;

    public Search(WeightedGraph<V> graph, Vertex<V> source) {
        this.graph = graph;
        this.source = source;
        this.distances = new HashMap<>();
        this.predecessors = new HashMap<>();
        this.visited = new HashSet<>();
    }

    public abstract void search();

    public double getDistance(Vertex<V> destination) {
        return distances.getOrDefault(destination, Double.POSITIVE_INFINITY);
    }

    public List<Vertex<V>> getPath(Vertex<V> destination) {
        List<Vertex<V>> path = new ArrayList<>();
        if (!visited.contains(destination)) {
            return path;
        }

        for (Vertex<V> current = destination; current != null; current = predecessors.get(current)) {
            path.add(0, current);
        }
        return path;
    }

    protected void printResults() {
        System.out.println("Distances from source " + source + ":");
        for (Map.Entry<Vertex<V>, Double> entry : distances.entrySet()) {
            System.out.println("To " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nPaths from source " + source + ":");
        for (Vertex<V> vertex : visited) {
            if (vertex != source) {
                List<Vertex<V>> path = getPath(vertex);
                System.out.print("To " + vertex + ": ");
                for (Vertex<V> v : path) {
                    System.out.print(v + " ");
                }
                System.out.println("(Distance: " + distances.get(vertex) + ")");
            }
        }
    }
}