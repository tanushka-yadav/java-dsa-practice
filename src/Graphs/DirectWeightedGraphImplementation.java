package Graphs;

import java.util.ArrayList;

//Edge Class
class Edge{
    VertexC destination;
    int weight;

    //Constructor
    Edge(VertexC destination, int weight){
        this.destination=destination;
        this.weight=weight;
    }
}

//Vertex Class
class VertexD{
    int data;
    ArrayList<Edge> edges;

    //Constructor
    VertexD(int data){
        this.data=data;
        edges=new ArrayList<>();
    }
}

//Directed Weighted Graph Class
class DirectedWeightedGraphD{
    ArrayList<Vertex> vertices;

    //Constructor
    DirectedWeightedGraphD(){
        vertices=new ArrayList<>();
    }

    //Add Vertex
    public void addVertex(int data){
        vertices.add(new Vertex(data));
    }
}

//Vertex Class
class VertexC{
    int data;
    ArrayList<Edge> edges;

    //Constructor
    VertexC(int data){
        this.data=data;
        edges=new ArrayList<>();
    }
}

//Directed Weighted Graph Class
class DirectedWeightedGraph{

    ArrayList<VertexC> vertices;

    //Constructor
    DirectedWeightedGraph(){
        vertices=new ArrayList<>();
    }

    //Add Vertex
    public void addVertex(int data){
        vertices.add(new VertexC(data));
    }

    //Find Vertex
    private VertexC getVertex(int data){
        for(VertexC vertex : vertices){
            if(vertex.data==data){
                return vertex;
            }
        }

        return null;
    }

    //Add Directed Weighted Edge
    public void addEdge(int source, int destination, int weight){

        VertexC src=getVertex(source);
        VertexC dest=getVertex(destination);

        if(src!=null && dest!=null){
            src.edges.add(new Edge(dest, weight));
        }
    }

    //Display Graph
    public void displayGraph(){

        System.out.println("Directed Weighted Graph: ");

        for(VertexC vertex : vertices){
            System.out.print("Vertex "+vertex.data+" -> ");

            for(Edge edge : vertex.edges){

                System.out.print("("+edge.destination.data+", Weight= "+edge.weight+")");
            }

            System.out.println();
        }
    }
}

//Main Class
public class DirectWeightedGraphImplementation {

    public static void main(String[] args){
        DirectedWeightedGraph graph=new DirectedWeightedGraph();

        //Add Vertices
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        //Add Directed Weighted Edges
        graph.addEdge(0,1,5);
        graph.addEdge(0,2,3);
        graph.addEdge(1,3, 7);
        graph.addEdge(2,3,4);
        graph.addEdge(3,4,2);
        graph.addEdge(4,1,6);

        //Display Graph
        graph.displayGraph();
    }
}
