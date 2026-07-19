package Trees;

import java.util.Scanner;

public class ArrayBinaryTreePostorder {

    int[] tree;
    int size;

    //Constructor
    public ArrayBinaryTreePostorder(int capacity){
        tree=new int[capacity];
        size=0;
    }

    //Insert elements
    public void insert(int value){
        if(size==tree.length){
            System.out.println("Tree is Full!");
            return;
        }
        tree[size]=value;
        size++;
    }

    //Postorder Traversal (Left -> Right -> Root)
    public void postorder(int index){
        if(index>=size){
            return;
        }

        postorder(2*index+1); //Left Child
        postorder(2*index+2); //Right Child
        System.out.print(tree[index]+" "); //Root
    }

    //Display Array
    public void display(){
        System.out.println("\nArray Representation: ");
        for(int i=0; i<size; i++){
            System.out.println("Index "+i+":"+tree[i]);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Maximum Size of Tree: ");
        int capacity=sc.nextInt();

        ArrayBinaryTreePostorder bt=new ArrayBinaryTreePostorder(capacity);

        System.out.print("Enter Number of Elements: ");
        int n=sc.nextInt();

        System.out.println("Enter Elements: ");

        for(int i=0;i<n; i++){
            bt.insert(sc.nextInt());
        }

        bt.display();

        System.out.print("\nPostorder Traversal: ");
        bt.postorder(0);

        sc.close();
    }
}
