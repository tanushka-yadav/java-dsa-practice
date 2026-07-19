package ShortestPath;

import java.util.*;

class EdgeD{
    int destination;
    int weight;

    EdgeD(int destination, int weight){
        this.destination=destination;
        this.weight=weight;
    }
}
public class DirectedGraphDijkstra {

    static void dijkstra(List<List<Edge>> graph, int source){
         int vertices=graph.size();
         int[] distance=new int[vertices];

         Arrays.fill(distance, Integer.MAX_VALUE);
         distance[source]=0;

         PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));

         pq.offer(new int[]{source,0});

         while(!pq.isEmpty()){

             int[] current=pq.poll();
             int currentVertex=current[0];
             int currentDistance=current[1];

             if(currentDistance>distance[currentVertex]){
                 continue;
             }

             for(Edge edge: graph.get(currentVertex)){

                 int neighbor=edge.destination;
                 int weight=edge.weight;

                 if(distance[currentVertex]!=Integer.MAX_VALUE && distance[currentVertex]+weight<distance[neighbor]){
                     distance[neighbor]=distance[currentVertex]+weight;
                     pq.offer(new int[]{neighbor, distance[neighbor]});
                 }
             }
         }

         System.out.println("Shortest Distance from Source Vertex "+source);

         for(int i=0; i<vertices; i++){
             if(distance[i]==Integer.MAX_VALUE)
                 System.out.println("Vertex "+i+" : Unreachable");
             else
                 System.out.println("Vertex "+i+" : "+distance[i]);
         }
    }

    public static void main(String[] args){

        int vertices=6;

        List<List<Edge>> graph=new ArrayList<>();

        for(int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }

        //Directed Edges
        graph.get(0).add(new Edge(1,4, -3));
        graph.get(0).add(new Edge(2,2, -3));

        graph.get(1).add(new Edge(2,5, -3));
        graph.get(1).add(new Edge(3,10, -3));

        graph.get(2).add(new Edge(4,3, -3));

        graph.get(4).add(new Edge(3,4, -3));
        graph.get(4).add(new Edge(5,5, -3));

        graph.get(3).add(new Edge(5,11, -3));

        int source=0;

        dijkstra(graph, source);

    }
}
