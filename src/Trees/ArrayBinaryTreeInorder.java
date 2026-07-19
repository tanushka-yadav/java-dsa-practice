package Trees;

import java.util.Scanner;

public class ArrayBinaryTreeInorder {

    int[] tree;
    int size;

    //Constructor
    public ArrayBinaryTreeInorder(int capacity){
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

    //Inorder Traversal (Left-> Root -> Right)
    public void inorder(int index){
        if(index>=size){
            return;
        }

        inorder(2*index+1);  //Left Child
        System.out.print(tree[index]+" ");  //Root
        inorder(2*index+2);  //Right Child
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

        ArrayBinaryTreeInorder bt=new ArrayBinaryTreeInorder(capacity);

        System.out.print("Enter Number of Elements: ");
        int n=sc.nextInt();

        System.out.println("Enter Elements: ");

        for(int i=0; i<n; i++){
            bt.insert(sc.nextInt());
        }

        bt.display();

        System.out.print("\nInorder Traversal: ");

        bt.inorder(0);

        sc.close();
    }
}
