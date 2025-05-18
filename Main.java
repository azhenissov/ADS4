import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a graph of Kazakhstan cities
        WeightedGraph<String> graph = new WeightedGraph<>();

        // Add vertices (cities)
        graph.addVertex("Astana");
        graph.addVertex("Karaganda");
        graph.addVertex("Balkash");
        graph.addVertex("Almaty");
        graph.addVertex("Pavlodar");
        graph.addVertex("Semey");
        graph.addVertex("Taldykorgan");
        graph.addVertex("Kokshetau");
        graph.addVertex("Taraz");

        // Add edges with distances between cities (in km)
        graph.addEdge("Astana", "Karaganda", 213.0);
        graph.addEdge("Karaganda", "Balkash", 367.0);
        graph.addEdge("Balkash", "Almaty", 380.0);
        graph.addEdge("Balkash", "Taraz", 530.0);
        graph.addEdge("Pavlodar", "Semey", 265.0);
        graph.addEdge("Almaty", "Taldykorgan", 250.0);
        graph.addEdge("Taldykorgan", "Semey", 620.0);
        graph.addEdge("Astana", "Pavlodar", 446.0);
        graph.addEdge("Astana", "Kokshetau", 300.0);

        System.out.println("Graph representation:");
        graph.printGraph();

        System.out.println("\n--- BFS from Astana ---");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, graph.getVertex("Astana"));
        bfs.search();

        System.out.println("\n--- Dijkstra from Astana ---");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, graph.getVertex("Astana"));
        dijkstra.search();

        // Show specific path
        System.out.println("\nPath from Astana to Taraz using Dijkstra:");
        List<Vertex<String>> path = dijkstra.getPath(graph.getVertex("Taraz"));
        if (!path.isEmpty()) {
            for (Vertex<String> vertex : path) {
                System.out.print(vertex + " -> ");
            }
            System.out.println("End");
            System.out.println("Total distance: " + dijkstra.getDistance(graph.getVertex("Taraz")) + " km");
        } else {
            System.out.println("No path exists");
        }
    }
}