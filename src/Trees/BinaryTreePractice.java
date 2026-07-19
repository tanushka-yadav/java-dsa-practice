package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePractice {

    //Node class
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    Node root;

    //Insert using level Order
    public void insert(int data){
        Node newNode=new Node(data);

        if(root==null){
            root=newNode;
            return;
        }

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node temp=queue.poll();

            if(temp.left==null){
                temp.left=newNode;
                return;
            }
            else{
                queue.add(temp.left);
            }

            if(temp.right==null){
                temp.right=newNode;
                return;
            }
            else{
                queue.add(temp.right);
            }
        }
    }

    //Preorder
    public void preorder(Node node){
        if(node==null)
            return;

        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }

    //Inorder
    public void inorder(Node node){
        if(node==null)
            return;

        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    //Postorder
    public void postorder(Node node){
        if(node==null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }

    //Level Order Traversal
    public void levelOrder(){
        if(root==null)
            return;

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node temp=queue.poll();

            System.out.print(temp.data+" ");

            if(temp.left!=null)
                queue.add(temp.left);

            if(temp.right!=null)
                queue.add(temp.right);
        }

    }

    //Count Total Nodes
    public int countNodes(Node node){
        if(node==null)
            return 0;

        return 1 + countNodes(node.left)+countNodes(node.right);
    }

    //Count Leaf Nodes
    public int countLeaves(Node node){
        if(node==null)
            return 0;

        if(node.left==null && node.right==null)
            return 1;

        return countLeaves(node.left)+countLeaves(node.right);
    }

    //Height of Tree
    public int height(Node node){
        if(node==null)
            return 0;

        int leftHeight=height(node.left);
        int rightHeight=height(node.right);

        return Math.max(leftHeight, rightHeight)+1;
    }

    //Search Node
    public boolean search(Node node, int key)
    {
        if(node==null)
            return false;

        if(node.data==key)
            return true;

        return search(node.left, key) || search(node.right, key);
    }

    //Find Maximum Value
    public int findMax(Node node){

        if(node==null)
            return Integer.MIN_VALUE;

        int leftMax=findMax(node.left);
        int rightMax=findMax(node.right);

        return Math.max(node.data, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args){

        BinaryTreePractice tree=new BinaryTreePractice();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);

        System.out.println("Preorder Traversal: ");
        tree.preorder(tree.root);

        System.out.println("\n");

        System.out.println("Inorder Traversal: ");
        tree.inorder(tree.root);

        System.out.println("\n");

        System.out.println("Postorder Traversal: ");
        tree.postorder(tree.root);

        System.out.println("\n");

        System.out.println("Level Order Traversal: ");
        tree.levelOrder();

        System.out.println("\n");

        System.out.println("Total Nodes = "+ tree.countNodes(tree.root));

        System.out.println("Leaf Nodes = "+ tree.countLeaves(tree.root));

        System.out.println("Height = "+ tree.height(tree.root));

        int key=50;

        if(tree.search(tree.root, key))
            System.out.println(key+" Found");
        else
            System.out.println(key+" Not Found");

        System.out.println("Maximum Value = "+tree.findMax(tree.root));
    }
}
