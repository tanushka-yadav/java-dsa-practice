static class NodeD{
    int data;
    NodeD left, right;

    NodeD(int data){
        this.data=data;
        left=right=null;
    }
}
public static class BSTDelete {

    NodeD root;

    NodeD insert(NodeD root, int data){
        if(root==null)
            return new NodeD(data);

        if(data<root.data)
            root.left=insert(root.left, data);
        else
            root.right=insert(root.right, data);

        return root;

    }

    NodeD findMin(NodeD root){

        while(root.left!=null)
            root=root.left;

        return root;
    }

    NodeD delete(NodeD root, int key){
        if(root==null)
            return null;

        if(key<root.data)
            root.left=delete(root.left, key);

        else if(key>root.data)
            root.right=delete(root.right, key);

        else{

            //No child
            if(root.left==null && root.right==null)
                return null;

            //One child
            if(root.left==null)
                return root.right;

            if(root.right==null)
                return root.left;

            //Two children
            NodeD temp=findMin(root.right);
            root.data=temp.data;
            root.right=delete(root.right, temp.data);
        }

        return root;
    }

    void inorder(NodeD root){

        if(root!=null)
            inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

}

public static void main(String[] args){

    BSTDelete tree=new BSTDelete();

    tree.root=tree.insert(tree.root, 50);
    tree.insert(tree.root, 30);
    tree.insert(tree.root, 70);
    tree.insert(tree.root, 20);
    tree.insert(tree.root, 40);
    tree.insert(tree.root, 60);
    tree.insert(tree.root, 80);

    System.out.println("Before Deletion: ");
    tree.inorder(tree.root);

    tree.root=tree.delete(tree.root, 70);

    System.out.println("\nAfter Deleting 70: ");
    tree.inorder(tree.root);
}
