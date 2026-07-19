package Graphs;
import java.util.ArrayList;

//Vertex Class
class Vertex{
    int data;
    ArrayList<Vertex> neighbors;

    //Constructor
    Vertex(int data){
        this.data=data;
        neighbors=new ArrayList<>();
    }
}

//Graphs Class
class Graph{

    ArrayList<Vertex> vertices;

    //Constructor
    Graph(){
        vertices=new ArrayList<>();
    }

    //Add Vertex
    public void addVertex(int data){
        vertices.add(new Vertex(data));
    }

    //Find Vertex
    private Vertex getVertex(int data){
        for(Vertex v : vertices){
            if(v.data==data){
                return v;
            }
        }
        return null;
    }

    //Add Edge (Undirected Graph)
    public void addEdge(int source, int destination){

        Vertex src=getVertex(source);
        Vertex dest=getVertex(destination);

        if(src!=null && dest!=null){
            src.neighbors.add(dest);
            dest.neighbors.add(src);
        }
    }

    //Display Graph
    public void displayGraph(){

        System.out.println("Graph Representation: ");

        for(Vertex vertex : vertices){

            System.out.print("Vertex "+vertex.data+" -> ");

            for(Vertex neighbor : vertex.neighbors){
                System.out.print(neighbor.data+" ");
            }

            System.out.println();
        }
    }
}

//Main Class
public class GraphImplementationUsingClasses {

    public static void main(String[] args){

        Graph graph=new Graph();

        //Add Vertices
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        //Add Edges
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);

        //Display Graph
        graph.displayGraph();
    }
}
