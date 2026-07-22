import java.util.*;

class EdgeN{
    int source;
    int destination;
    int weight;

    EdgeN(int source, int destination, int weight){
        this.source=source;
        this.destination=destination;
        this.weight=weight;
    }
}

public class BellmanFordNegativeCycle {

    static void detectNegativeCycle(List<EdgeN> edges, int vertices, int source){

        int[] distance=new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source]=0;

        //Step 1: Relax all edges (V-1) times
        for(int i=1; i<vertices; i++){
            for(EdgeN edge:edges){
                if(distance[edge.source]!=Integer.MAX_VALUE && distance[edge.source]+edge.weight<distance[edge.destination]){
                    distance[edge.destination]=distance[edge.source]+edge.weight;
                }
            }
        }

        //Step 2: Check for Negative Weight Cycle
        boolean hasNegativeCycle=false;

        for(EdgeN edge: edges){
            if(distance[edge.source]!=Integer.MAX_VALUE && distance[edge.source]+edge.weight<distance[edge.destination]){
                hasNegativeCycle=true;
                break;
            }
        }

        if(hasNegativeCycle){
            System.out.println("Graph contains a Negative Weight Cycle.");
        }else{
            System.out.println("No Negative Weight Cycle found.");

            System.out.println("\nShortest Distances: ");
            for(int i=0; i<vertices ;i++){
                if(distance[i]==Integer.MAX_VALUE)
                    System.out.println("Vertex "+i+" : Unreachable");

                else
                    System.out.println("Vertex "+i+" : "+distance[i]);
            }
        }
    }

    public static void main(String[] args){
        int vertices=4;

        List<EdgeN> edges=new ArrayList<>();

        //Graph containing a Negative Weight Cycle
        edges.add(new EdgeN(0,1,1));
        edges.add(new EdgeN(1,2,-1));
        edges.add(new EdgeN(2,3,-1));
        edges.add(new EdgeN(3,1,-1));

        int source=0;

        detectNegativeCycle(edges, vertices, source);
    }
}
