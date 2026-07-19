package Trees;

//InOrderTraversal.java

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
public class InOrderTraversal {

    //In-Order Traversal Method
    public void inOrder(Node root){
        if(root==null){
            return;
        }

        //Visit left Subtree
        inOrder(root.left);

        //Visit Root Node
        System.out.print(root.data+" ");

        //Visit Right Subtree
        inOrder(root.right);
    }

    public static void main(String[] args){

        InOrderTraversal tree=new InOrderTraversal();

        /*

        1
       / \
      2   3
     /\  /\
    4 5 6 7

    In-Order Output:
    4 2 5 1 6 3 7

         */

        Node root=new Node(1);

        root.left=new Node(2);
        root.right=new Node(3);

        root.left.left=new Node(4);
        root.left.right=new Node(5);

        root.right.left=new Node(6);
        root.right.right=new Node(7);

        System.out.println("Binary Tree In-Order Traversal: ");
        tree.inOrder(root);
    }
}
