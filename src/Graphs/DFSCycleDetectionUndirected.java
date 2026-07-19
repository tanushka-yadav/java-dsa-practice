package Graphs;

import java.util.ArrayList;

public class DFSCycleDetectionUndirected {

    //Number of vertices
    private int vertices;

    //Adjacency list
    private ArrayList<ArrayList<Integer>> graph;

    //Constructor
    public DFSCycleDetectionUndirected(int vertices){

        this.vertices=vertices;
        graph=new ArrayList<>();

        for(int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }
    }

    //Add an undirected edge
    public void addEdge(int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    //DFS method for cycle detection
    private boolean dfs(int current, boolean[] visited, int parent){

        visited[current]=true;

        for(int neighbor : graph.get(current)){

            //If not visited, visit recursively
            if(!visited[neighbor]){
                if(dfs(neighbor, visited, current))
                    return true;
            }

            //If visited and not parent , cycle exists
            else if(neighbor != parent){
                return true;
            }
        }

        return false;
    }

    //Check for cycle
    public boolean hasCycle(){
        boolean[] visited=new boolean[vertices];

        for(int i=0; i<vertices; i++){

            if(!visited[i]){
                if(dfs(i, visited, -1))
                    return true;
            }
        }

        return false;
    }

    //Display Graph
    public void displayGraph(){
        System.out.println("Adjacency List: ");

        for(int i=0; i<vertices; i++){
            System.out.print(i+" -> ");

            for(int neighbor : graph.get(i)){
                System.out.print(neighbor+" ");
            }

            System.out.println();
        }
    }

    //Main Method

    public static void  main(String[] args){
        DFSCycleDetectionUndirected graph=new DFSCycleDetectionUndirected(6);

        graph.addEdge(0,1);
        graph.addEdge(1, 2);
        graph.addEdge(2,0); //Creates a cycle

        graph.addEdge(3,4);
        graph.addEdge(4,5);

        graph.displayGraph();

        if(graph.hasCycle()){
            System.out.println("\nCycle Detected in the Graph. ");
        }else{
            System.out.println("\nNo Cycle Found in the Graph. ");
        }
    }

}
