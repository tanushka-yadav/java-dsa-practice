package Graphs;

import java.util.ArrayList;

public class UnionFindCycleDetection {

    //Edge class
    static class Edge{
        int source, destination;

        Edge(int source, int destination){
            this.source=source;
            this.destination=destination;
        }
    }

    //Number of vertices
    private int vertices;

    //List of edges
    private ArrayList<Edge> edges;

   //Constructor
    public UnionFindCycleDetection(int vertices){
        this.vertices=vertices;
        edges=new ArrayList<>();
    }

    //Add Edge
    public void addEdge(int source, int destination){
        edges.add(new Edge(source, destination));
    }

    //Find operation
    private int find(int[] parent, int vertex){

        if(parent[vertex]==-1)
            return vertex;

        return find(parent, parent[vertex]);
    }

    //Union operation
    private void union(int[] parent, int sourceRoot, int destinationRoot){
        parent[sourceRoot]=destinationRoot;
    }

    //Cycle Detection
    public boolean hasCycle(){
        int[] parent=new int[vertices];

        //Initialize parent array
        for(int i=0; i<vertices; i++)
            parent[i]=-1;

        for(Edge edge: edges){
            int sourceRoot=find(parent, edge.source);
            int destinationRoot=find(parent, edge.destination);

            //Cycle exists
            if(sourceRoot==destinationRoot)
                return true;

            union(parent, sourceRoot, destinationRoot);
        }
        return false;
    }

    //Display Edges
    public void displayEdges(){
        System.out.println("Graph Edges: ");

        for(Edge edge : edges){
            System.out.println(edge.source+" --> "+edge.destination);
        }
    }

    //Main Method
    public static void main(String[] args){

        UnionFindCycleDetection graph=new UnionFindCycleDetection(4);

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0); //Creates a cycle

        graph.displayEdges();

        if(graph.hasCycle()){
            System.out.println("\nCycle Detected in the Graph.");
        }else{
            System.out.println("\nNo Cycle Found in the Graph. ");
        }
    }
}
