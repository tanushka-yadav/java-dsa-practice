package Trees;

class NodeT{
    int data;
    NodeT left, right;

    NodeT(int data){
        this.data=data;
        left=right=null;
    }
}
public class BSTTraversal {

    NodeT root;

    //Insert Node
    NodeT insert(NodeT root, int data){
        if(root==null){
            return new NodeT(data);
        }

        if(data<root.data)
            root.left=insert(root.left, data);
        else
            root.right=insert(root.right, data);

        return root;
    }

    //Inorder Traversal
    void inorder(NodeT root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    //Preorder Traversal
    void preorder(NodeT root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    //Postorder Traversal
    void postorder(NodeT root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public static void main(String[] args){

        BSTTraversal tree=new BSTTraversal();

        tree.root= tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("Inorder Traversal: ");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal: ");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal: ");
        tree.postorder(tree.root);
    }
}
