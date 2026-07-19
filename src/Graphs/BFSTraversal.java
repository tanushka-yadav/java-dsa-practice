package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class GraphB{
    private int vertices;
    private LinkedList<Integer>[] adjList;

    //Constructor
    GraphB(int vertices){
        this.vertices=vertices;
        adjList=new LinkedList[vertices];

        for(int i=0; i<vertices; i++){
            adjList[i]=new LinkedList<>();
        }
    }

    //Add Edge
    void addEdge(int source, int destination){
        adjList[source].add(destination);

        //Uncomment the next line for an undirected Graph
        //adjList[destination].add(source);
    }

    //BFS Traversal
    void BFS(int startVertex){

        boolean[] visited=new boolean[vertices];
        Queue<Integer> queue=new LinkedList<>();

        visited[startVertex]=true;
        queue.offer(startVertex);

        System.out.print("BFS Traversal: ");

        while(!queue.isEmpty()){

            int current=queue.poll();
            System.out.print(current+" ");

            for(int neighbour : adjList[current]){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
        }

        System.out.println();
    }
}
public class BFSTraversal {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices=sc.nextInt();

        GraphB graph =new GraphB(vertices);

        System.out.print("Enter number of edges: ");
        int edges=sc.nextInt();

        System.out.println("Enter edges (Source Destination): ");

        for(int i=0;i<edges; i++){
            int source=sc.nextInt();
            int destination=sc.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.print("Enter starting vertex for BFS: ");
        int start =sc.nextInt();

        graph.BFS(start);

        sc.close();
    }
}
