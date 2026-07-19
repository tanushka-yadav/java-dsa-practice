package Graphs;

import java.util.ArrayList;

public class DFSCycleDetectionDirected {

    //Number of Vertices
    private int vertices;

    //Adjacency List
    private ArrayList<ArrayList<Integer>> graph;

    //Constructor
    public DFSCycleDetectionDirected(int vertices){
        this.vertices=vertices;
        graph=new ArrayList<>();

        for(int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }
    }

    //Add directed edge
    public void addEdge(int source, int destination){
        graph.get(source).add(destination);
    }

    //DFS for cycle detection
    private boolean dfs(int current, boolean[] visited, boolean[] recStack){

        visited[current]=true;
        recStack[current]=true;

        for(int neighbor : graph.get(current)){

            if(!visited[neighbor]){
                if(dfs(neighbor, visited, recStack))
                    return true;
            }

            //If neighbor is already in recursion stak
            else if(recStack[neighbor]){
                return true;
            }
        }

        //Remove current node from recursion stack
        recStack[current]=false;

        return false;
    }

    //Check for cycle
    public boolean hasCycle(){

        boolean[] visited=new boolean[vertices];
        boolean[] recStack=new boolean[vertices];

        for(int i=0; i<vertices; i++){
            if(!visited[i]){
                if(dfs(i, visited, recStack))
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
    public static void main(String[] args){
        DFSCycleDetectionDirected graph=new DFSCycleDetectionDirected(5);

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1); //create a cycle
        graph.addEdge(3,4);

        graph.displayGraph();

        if(graph.hasCycle()){
            System.out.println("\nCycle Detected in the Directed Graph.");
        }else{
            System.out.println("\nNo Cycle Found in the Directed Graph. ");
        }
    }
}
