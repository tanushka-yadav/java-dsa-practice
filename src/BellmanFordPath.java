import java.util.*;

class EdgeP{

    int source;
    int destination;
    int weight;

    EdgeP(int source, int destination, int weight){
        this.source=source;
        this.destination=destination;
        this.weight=weight;
    }
}

public class BellmanFordPath {

    static void bellmanFord(List<Edge> edges,int vertices, int source){

        int[] distance=new int[vertices];
        int[] parent=new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        distance[source]=0;

        //Relax all edges (V-1) times
        for(int i=1; i<vertices; i++){
            for(Edge edge : edges){
                if(distance[edge.source]!=Integer.MAX_VALUE && distance[edge.source]+edge.weight<distance[edge.destination]){
                    distance[edge.destination]=distance[edge.source]+edge.weight;

                    parent[edge.destination]=edge.source;
                }
            }
        }

        //Check for Negative Weight Cycle
        for(Edge edge: edges){
            if(distance[edge.source]!=Integer.MAX_VALUE && distance[edge.source]+edge.weight<distance[edge.destination]){
                System.out.println("Graph contains a Negative Weight Cycle.");
                return;
            }
        }

        //Print shortest distances and paths
        System.out.println("Shortest Paths from Source Vertex "+source+":");

        for(int i=0; i<vertices; i++){
            if(distance[i]==Integer.MAX_VALUE){
                System.out.println("Vertex "+i+" : Unreachable");
            }else{

                System.out.print("Vertex "+i+" | Distance = "+distance[i]+" | Path = ");
                printPath(parent,i);
                System.out.println();
            }
        }
    }

    static void printPath(int[] parent, int vertex){
        if(vertex==-1)
            return;

        printPath(parent, parent[vertex]);
        System.out.print(vertex+" ");
    }

    public static void main(String[] args){
        int vertices=5;

        List<Edge> edges=new ArrayList<>();

        edges.add(new Edge(0,1,6));
        edges.add(new Edge(0,2,7));
        edges.add(new Edge(1,2,8));
        edges.add(new Edge(1,3,5));
        edges.add(new Edge(1, 4, -4));
        edges.add(new Edge(2, 3, -3));
        edges.add(new Edge(2, 4, 9));
        edges.add(new Edge(3, 1, -2));
        edges.add(new Edge(4, 0, 2));
        edges.add(new Edge(4, 3, 7));

        int source=0;
        bellmanFord(edges, vertices, source);
    }
}
