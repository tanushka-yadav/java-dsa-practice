package Trees;

//DSA Post-Order Traversal in Java

class NodeP{
    int data;
    NodeP left, right;

    //Constructor
    NodeP(int data){
        this.data=data;
        left=right=null;
    }
}
public class PostOrderTraversal {

    //Method for Post-Order Traversal
    public static void postOrder(NodeP root){
        if(root==null){
            return;
        }

        //Visit Left Subtree
        postOrder(root.left);

        //Visit Right Subtree
        postOrder(root.right);

        //Visit Root Node
        System.out.print(root.data+" ");
    }

    public static void main(String[] args){

        /*

        1
       / \
      2   3
     /\  /\
    4 5 6 7

         */

        NodeP root=new NodeP(1);

        root.left=new NodeP(2);
        root.right=new NodeP(3);

        root.left.left=new NodeP(4);
        root.left.right=new NodeP(5);

        root.right.left=new NodeP(6);
        root.right.right=new NodeP(7);

        System.out.println("Post-Order Traversal of Binary Tree: ");
        postOrder(root);
    }
}
