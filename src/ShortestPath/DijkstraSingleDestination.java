package ShortestPath;

import java.util.*;

class EdgeS{
    int destination;
    int weight;

    EdgeS(int destination, int weight){
        this.destination=destination;
        this.weight=weight;
    }
}
public class DijkstraSingleDestination {

    static void dijkstra(List<List<Edge>> graph, int source, int destination){

        int vertices=graph.size();

        int[] distance=new int[vertices];
        int[] parent=new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        distance[source]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));

        pq.offer(new int[]{source, 0});

        while(!pq.isEmpty()){
            int[] current=pq.poll();
            int u=current[0];
            int currentDistance=current[1];

            if(u==destination)
                break;

            if(currentDistance>distance[u])
                continue;

            for(Edge edge: graph.get(u)){
                int v=edge.destination;
                int weight=edge.weight;

                if(distance[u]+weight<distance[v]){
                    distance[v]=distance[u]+weight;
                    parent[v]=u;
                    pq.offer(new int[]{v, distance[v]});
                }
            }
        }

        if(distance[destination]==Integer.MAX_VALUE){
            System.out.println("No path exists. ");
        }else{
            System.out.println("Shortest Distance = "+distance[destination]);
            System.out.print("Shortest Path = ");
            printPath(parent, destination);
            System.out.println();
        }
    }

    static void printPath(int[] parent, int vertex){

        if(vertex==-1)
            return;

        printPath(parent, parent[vertex]);
        System.out.print(vertex+" ");
    }

    public static void main(String[] args){

        int vertices=6;

        List<List<Edge>> graph=new ArrayList<>();

        for(int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }

        //Directed Weighted Graph
        graph.get(0).add(new Edge(1,4, -3));
        graph.get(0).add(new Edge(2,2, -3));
        graph.get(1).add(new Edge(3,10, -3));
        graph.get(2).add(new Edge(4,3, -3));
        graph.get(4).add(new Edge(3,4, -3));
        graph.get(4).add(new Edge(5,5, -3));
        graph.get(3).add(new Edge(5,11, -3));

        int source=0;
        int destination=5;

        dijkstra(graph, source, destination);
    }
}
