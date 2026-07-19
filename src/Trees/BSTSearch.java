package Trees;

class NodeS{
    int data;
    NodeS left, right;

    NodeS(int data){
        this.data=data;
        left=right=null;
    }
}
public class BSTSearch {

    NodeS root;

    NodeS insert(NodeS root, int data){
        if(root==null)
            return new NodeS(data);

        if(data<root.data)
            root.left=insert(root.left, data);
        else
            root.right=insert(root.right, data);

        return root;
    }

    boolean search(NodeS root, int key){

        if(root==null)
            return false;

        if(root.data==key)
            return true;

        if(key<root.data)
            return search(root.left, key);

        return search(root.right, key);
    }

    public static void main(String[] args){

        BSTSearch tree=new BSTSearch();

        tree.root=tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        int key=60;

        if(tree.search(tree.root, key))
            System.out.println(key+ " Found in BST.");
        else
            System.out.println(key+" Not Found.");
    }
}
