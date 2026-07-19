package Graphs;

import java.util.ArrayList;

public class GraphImplementation {

    //Number of vertices
    private int vertices;

    //Adjacency List
    private ArrayList<ArrayList<Integer>> graph;

    //Constructor
    public GraphImplementation(int vertices){
        this.vertices=vertices;
        graph=new ArrayList<>();

        //Create an empty adjacency list for each vertex
        for(int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }

    }

    //Add an edge(Undirected Graph)
    public void addEdge(int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    //Display the graph
    public void displayGraph() {
        System.out.println("Graph Representation (Adjacency List): ");

        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " -> ");

            for (int neighbor : graph.get(i)) {
                System.out.print(neighbor + " ");
            }

            System.out.println();
        }
    }

    //Main Method
public static void main(String[] args){

        //create a graph with 5 vertices(0-4)
    GraphImplementation g=new GraphImplementation(5);

    //Add edges
    g.addEdge(0,1);
    g.addEdge(0,4);
    g.addEdge(1,2);
    g.addEdge(1,3);
    g.addEdge(1,4);
    g.addEdge(2,3);
    g.addEdge(3,4);

    //Display Graph
    g.displayGraph();

    }
}


