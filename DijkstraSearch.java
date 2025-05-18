import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(graph, source);
    }

    @Override
    public void search() {
        // Priority queue to store vertices with their distances
        PriorityQueue<VertexDistance<V>> priorityQueue = new PriorityQueue<>();

        // Initialize distances to infinity for all vertices
        for (Vertex<V> vertex : graph.getVertices()) {
            distances.put(vertex, vertex.equals(source) ? 0.0 : Double.POSITIVE_INFINITY);
            priorityQueue.add(new VertexDistance<>(vertex, distances.get(vertex)));
        }

        while (!priorityQueue.isEmpty()) {
            VertexDistance<V> current = priorityQueue.poll();
            Vertex<V> currentVertex = current.vertex;
            double currentDistance = current.distance;

            // If we've already processed this vertex with a shorter path, skip it
            if (currentDistance > distances.get(currentVertex)) {
                continue;
            }

            visited.add(currentVertex);

            // Process all neighbors
            for (Map.Entry<Vertex<V>, Double> entry : currentVertex.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                double distanceToNeighbor = distances.get(currentVertex) + weight;

                // If we found a shorter path to the neighbor
                if (distanceToNeighbor < distances.get(neighbor)) {
                    distances.put(neighbor, distanceToNeighbor);
                    predecessors.put(neighbor, currentVertex);
                    priorityQueue.add(new VertexDistance<>(neighbor, distanceToNeighbor));
                }
            }
        }

        printResults();
    }

    // Helper class for priority queue
    private static class VertexDistance<V> implements Comparable<VertexDistance<V>> {
        Vertex<V> vertex;
        double distance;

        public VertexDistance(Vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexDistance<V> other) {
            return Double.compare(this.distance, other.distance);
        }
    }
}
