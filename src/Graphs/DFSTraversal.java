package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class GraphDFS{
    private int vertices;
    private LinkedList<Integer>[] adjList;

    //Constructor
    GraphDFS(int vertices){
        this.vertices=vertices;
        adjList=new LinkedList[vertices];

        for(int i=0; i<vertices; i++){
            adjList[i]=new LinkedList<>();
        }
    }

    //Add Edge
    void addEdge(int source, int destination){
        adjList[source].add(destination);

        //Uncomment the next line for an Undirected Graph
        //adjList[destination].add(source);
    }

    //DFS Utility Method
    void DFSUtil(int vertex, boolean[] visited){
        visited[vertex]=true;
        System.out.print(vertex +" ");

        for(int neighbour : adjList[vertex]){
            if(!visited[neighbour]){
                DFSUtil(neighbour, visited);
            }
        }
    }

    //DFS Traversal
    void DFS(int startVertex){
        boolean[] visited =new boolean[vertices];

        System.out.print("DFS Traversal: ");
        DFSUtil(startVertex, visited);
        System.out.println();
    }
}
public class DFSTraversal {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of Vertices: ");
        int vertices=sc.nextInt();

        GraphDFS graph=new GraphDFS(vertices);

        System.out.print("Enter number of edges: ");
        int edges=sc.nextInt();

        System.out.println("Enter edges (Source Destination): ");

        for(int i=0;i<edges; i++){
            int source=sc.nextInt();
            int destination=sc.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.print("Enter starting vertex for DFS: ");
        int start=sc.nextInt();

        graph.DFS(start);

        sc.close();
    }
}
