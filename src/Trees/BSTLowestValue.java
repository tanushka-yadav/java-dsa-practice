package Trees;

class NodeL{
    int data;
    NodeL left, right;

    NodeL(int data){
        this.data=data;
        left=right=null;
    }
}
public class BSTLowestValue {

    NodeL root;

    NodeL insert(NodeL root, int data){

        if(root==null)
            return new NodeL(data);

        if(data<root.data)
            root.left=insert(root.left, data);
        else
            root.right=insert(root.right, data);

        return root;

    }

    int findLowest(NodeL root){
        while(root.left!=null)
            root=root.left;

        return root.data;
    }

    public static void main(String[] args){

        BSTLowestValue tree=new BSTLowestValue();

        tree.root=tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("Lowest Value= "+tree.findLowest(tree.root));
    }
}
