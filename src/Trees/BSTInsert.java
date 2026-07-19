package Trees;

class NodeI{
    int data;
    NodeI left, right;

    NodeI(int data){
        this.data=data;
        left=right=null;
    }
}
public class BSTInsert {

    NodeI root;

    NodeI insert(NodeI root, int data){

        if(root==null)
            return new NodeI(data);

        if(data<root.data)
            root.left=insert(root.left, data);
        else
            root.right=insert(root.right, data);

        return root;
    }

    void inorder(NodeI root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    public static void main(String[] args){

        BSTInsert tree=new BSTInsert();

        tree.root=tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("BST after inserting nodes: ");

        tree.inorder(tree.root);
    }
}
