package Trees;

public class PreOrderTraversalPractice {

    //Node class
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    Node root;

    //Pre-order Traversal
    public void preOrder(Node node){

        if(node==null){
            return;
        }

        System.out.print(node.data+" ");

        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args){

        PreOrderTraversalPractice tree=new PreOrderTraversalPractice();

        //Creating Binary Tree
        tree.root=new Node(10);

        tree.root.left=new Node(20);
        tree.root.right=new Node(30);

        tree.root.left.left=new Node(40);
        tree.root.left.right=new Node(50);

        tree.root.right.left=new Node(60);
        tree.root.right.right=new Node(70);

        System.out.println("Pre-order Traversal: ");

        tree.preOrder(tree.root);
    }
}
