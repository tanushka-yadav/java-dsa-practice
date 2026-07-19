package Trees;

import java.util.Scanner;

public class ArrayBinaryTree {

    private int[] tree;
    private int size;

    //Constructor
    public ArrayBinaryTree(int capacity){
        tree=new int[capacity];
        size=0;
    }

    //Insert element
    public void insert(int value){
        if(size>=tree.length){
            System.out.println("Tree is full! Cannot insert "+ value);
            return;
        }

        tree[size]=value;
        size++;
    }

    //Display array representation
    public void display(){
        if(size==0){
            System.out.println("Tree is empty.");
            return;
        }

        System.out.println("\nArray Representation of Binary Tree.");
        for(int i=0; i<size; i++){
            System.out.println("Index "+i+" -> "+ tree[i]);
        }
    }

    //Preorder Traversal
    public void preorder(int index){
        if(index>=size)
            return;

        System.out.print(tree[index]+ " ");
        preorder(2*index+1);
        preorder(2*index+2);
    }

    //Inorder Traversal
    public void inorder(int index){
        if(index>=size)
            return;

        inorder(2*index+1);
        System.out.print(tree[index]+ " ");
        inorder(2*index+2);
    }

    //Postorder Traversal
    public void postorder(int index){
        if(index>=size)
            return;

        postorder(2*index+1);
        postorder(2*index+2);
        System.out.print(tree[index]+ " ");
    }

    //Main Method
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter maximum size of Binary Tree: ");
        int capacity=sc.nextInt();

        ArrayBinaryTree bt=new ArrayBinaryTree(capacity);

        System.out.print("Enter number of elements to insert: ");
        int n=sc.nextInt();

        if(n>capacity){
            System.out.println("Number of elements exceeds tree capacity.");
            return;
        }

        System.out.println("Enter elements: ");

        for(int i=0; i<n; i++){
            bt.insert(sc.nextInt());
        }

        bt.display();

        System.out.println("\nPreorder Traversal: ");
        bt.preorder(0);

        System.out.println("\n\nInorder Traversal: ");
        bt.inorder(0);

        System.out.println("\n\nPostorder Traversal: ");
        bt.postorder(0);

        sc.close();
    }
}
