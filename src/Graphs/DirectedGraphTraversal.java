package Graphs;

import java.util.*;

class DirectedGraph{
    private int vertices;
    private LinkedList<Integer>[] adjList;

    //Constructor
    DirectedGraph(int vertices){
        this.vertices=vertices;
        adjList=new LinkedList[vertices];

        for(int i=0; i<vertices; i++){
            adjList[i]=new LinkedList<>();
        }
    }

    //Add a directed edge
    void addEdge(int source, int destination){
        adjList[source].add(destination);
    }

    //-- DFS --

    void DFSUtil(int vertex, boolean[] visited){

        visited[vertex]=true;
        System.out.print(vertex+" ");

        for(int neighbour : adjList[vertex]){
            if(!visited[neighbour]){
                DFSUtil(neighbour, visited);
            }
        }
    }

    void DFS(int startVertex){
        boolean[] visited=new boolean[vertices];

        System.out.print("\nDFS Traversal: ");
        DFSUtil(startVertex, visited);
        System.out.println();
    }

    //-- BFS --

    void BFS(int startVertex){
        boolean[] visited =new boolean[vertices];
        Queue<Integer> queue=new LinkedList<>();

        visited[startVertex] =true;
        queue.offer(startVertex);

        System.out.print("BFS Traversal: ");

        while(!queue.isEmpty()){

            int current=queue.poll();
            System.out.print(current+" ");

            for(int neighbour :  adjList[current]){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
        }

        System.out.println();
    }
}
public class DirectedGraphTraversal {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices=sc.nextInt();

        DirectedGraph graph=new DirectedGraph(vertices);

        System.out.print("Enter number of directed edges: ");
        int edges=sc.nextInt();

        System.out.println("Enter each edge (Source Destination): ");

        for(int i=0; i<edges; i++){

            int source=sc.nextInt();
            int destination=sc.nextInt();

            graph.addEdge(source, destination);
        }

        System.out.print("Enter starting vertex: ");
        int start=sc.nextInt();

        graph.BFS(start);
        graph.DFS(start);

        sc.close();
    }
}
