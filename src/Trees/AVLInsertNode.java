package Trees;

//AVL Tree - Insert Node Implementation in Java

class NodeAVLI{
    int data;
    int height;
    NodeAVLI left, right;

    NodeAVLI(int data){
        this.data=data;
        this.height=1;
    }
}
class AVLTree{
    //Get height of node
    int height(NodeAVLI node){
        if(node==null)
            return 0;
        return node.height;
    }

    //Return maximum of two numbers
    int max(int a, int b){
        return (a>b)?a:b;
    }

    //Get balance factor
    int getBalance(NodeAVLI node){
        if(node==null)
            return 0;
        return height(node.left)-height(node.right);
    }

    //Right Rotate
    NodeAVLI rightRotate(NodeAVLI y){
        NodeAVLI x=y.left;
        NodeAVLI T2=x.right;

        //Perform rotation
        x.right=y;
        y.left=T2;

        //Update heights
        y.height=max(height(y.left), height(y.right))+1;
        x.height=max(height(x.left), height(x.right))+1;

        return x;
    }

    //Left Rotate
    NodeAVLI leftRotate(NodeAVLI x){
        NodeAVLI y=x.right;
        NodeAVLI T2=y.left;

        //Perform rotation
        y.left=x;
        x.right=T2;

        //Update heights
        x.height=max(height(x.left), height(x.right))+1;
        y.height=max(height(y.left), height(y.right))+1;

        return y;
    }

    //Insert a node
    NodeAVLI insert(NodeAVLI node, int key){

        //Normal BST insertion
        if(node==null)
            return new NodeAVLI(key);

        if(key<node.data)
            node.left=insert(node.left, key);
        else if(key>node.data)
            node.right=insert(node.right, key);
        else
            return node; //Duplicate values not allowed

        //Update height
        node.height=1+max(height(node.left), height(node.right));

        //Get balance factor
        int balance=getBalance(node);

        //Left Left Case
        if(balance>1 && key<node.left.data)
            return rightRotate(node);

        //Right Right Case
        if(balance<-1 && key>node.right.data)
            return leftRotate(node);

        //Left Right Case
        if(balance>1 && key>node.left.data){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }

        //Right Left Case
        if(balance<-1 && key<node.right.data){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    //Inorder Traversal
    void inorder(NodeAVLI node){
        if(node!=null){
            inorder(node.left);
            System.out.print(node.data+" ");
            inorder(node.right);
        }
    }
}
public class AVLInsertNode {

    public static void main(String[] args){
        AVLTree tree=new AVLTree();
        NodeAVLI root=null;

        root=tree.insert(root, 30);
        root=tree.insert(root, 20);
        root=tree.insert(root, 40);
        root=tree.insert(root, 10);
        root=tree.insert(root, 25);
        root=tree.insert(root, 50);
        root=tree.insert(root, 5);

        System.out.println("Inorder Traversal of AVL Tree: ");
        tree.inorder(root);
    }
}
