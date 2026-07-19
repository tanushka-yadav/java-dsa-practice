import java.util.*;

class Edge{
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight){
        this.source=source;
        this.destination=destination;
        this.weight=weight;
    }
}


public class BellmanFordNegativeEdges {

    static void bellmanFord(List<Edge> edges, int vertices, int source){

        int[] distance=new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source]=0;

        //Relax all edges V-1 times
        for(int i=1; i<vertices; i++){
            for(Edge edge: edges){

                if(distance[edge.source]!=Integer.MAX_VALUE && distance[edge.source]+ edge.weight<distance[edge.destination]){
                    distance[edge.destination]=distance[edge.source]+edge.weight;
                }
            }
        }

        //Check for negative weight cycle
        for(Edge edge : edges){
            if(distance[edge.source]!=Integer.MAX_VALUE && distance[edge.source]+edge.weight<distance[edge.destination]){
                System.out.println("Negative Weight Cycle Detected!");
                return;
            }
        }

        //Print shortest distances
        System.out.println("Shortest Distance from Source Vertex "+source);

        for(int i=0; i<vertices; i++){
            if(distance[i]==Integer.MAX_VALUE)
                System.out.println("Vertex "+i+" : Unreachable");
            else
                System.out.println("Vertex "+i+" : "+distance[i]);
        }
    }

    public static void main(String[] args){
        int vertices=5;

        List<Edge> edges = new ArrayList<>();

        // Graph with negative edges but NO negative cycle
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 2));
        edges.add(new Edge(1, 2, -2));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(2, 3, 3));
        edges.add(new Edge(3, 4, 2));

        int source = 0;

        bellmanFord(edges, vertices, source);
    }
}
