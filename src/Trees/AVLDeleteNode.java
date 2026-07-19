package Trees;
//AVL Tree- Delete Node Implementation in Java

class Nodeavld{
    int data;
    int height;
    Nodeavld left, right;

    Nodeavld(int data){
        this.data=data;
        this.height=1;
    }
}

class AVLDTree{

    //Get height
    int height(Nodeavld node){
        if(node==null)
            return 0;
        return node.height;
    }

    //Maximum of two numbers
    int max(int a, int b){
        return (a>b)?a:b;
    }

    //Get balance factor
    int getBalance(Nodeavld node){
        if(node==null)
            return 0;
        return height(node.left)-height(node.right);
    }

    //Right Rotation
    Nodeavld rightRotate(Nodeavld y){
        Nodeavld x=y.left;
        Nodeavld T2=x.right;

        x.right=y;
        y.left=T2;

        y.height=max(height(y.left), height(y.right))+1;
        x.height=max(height(x.left), height(y.right))+1;

        return x;
    }

    //Left Rotation
    Nodeavld leftRotate(Nodeavld x){
        Nodeavld y=x.right;
        Nodeavld T2=y.left;

        y.left=x;
        x.right=T2;

        x.height=max(height(x.left), height(x.right))+1;
        y.height=max(height(y.left), height(y.right))+1;

        return y;
    }

    //Insert Node
    Nodeavld insert(Nodeavld node, int key){

        if(node==null)
            return new Nodeavld(key);

        if(key<node.data)
            node.left=insert(node.left, key);
        else if(key>node.data)
            node.right=insert(node.right, key);
        else
            return node;

        node.height=1+max(height(node.left),height(node.right));

        int balance=getBalance(node);

        //LL
        if(balance>1 && key<node.left.data)
            return rightRotate(node);

        //RR
        if(balance<-1 && key> node.right.data)
            return leftRotate(node);

        //LR
        if(balance>1 && key>node.left.data)
        {
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }

        //RL
        if(balance <-1 && key<node.right.data){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        return node;


    }

    //Find node with minimum value
    Nodeavld minValueNode(Nodeavld node){
        Nodeavld current =node;

        while(current.left!=null)
            current=current.left;

        return current;
    }

    //Delete Node
    Nodeavld delete(Nodeavld root, int key){

        if(root==null)
            return root;

        if(key<root.data)
            root.left=delete(root.left, key);

        else if(key>root.data)
            root.right=delete(root.right, key);

        else{

            //Node with one child or no child
            if((root.left==null) || (root.right==null)){

                Nodeavld temp;

                if(root.left!=null)
                    temp=root.left;
                else
                    temp=root.right;

                if(temp==null){
                    root=null;
                }else{
                    root=temp;
                }
            }

            //Node with two children
            else{
                Nodeavld temp=minValueNode(root.right);
                root.data=temp.data;
                root.right=delete(root.right, temp.data);
            }
        }

        if(root==null)
            return root;

        //Update height
        root.height=1+max(height(root.left), height(root.right));

        //Balance factor
        int balance=getBalance(root);

        //LL
        if(balance>1 && getBalance(root.left)>=0)
            return rightRotate(root);

        //LR
        if(balance>1 && getBalance(root.left)<0){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }

        //RR
        if(balance<-1 && getBalance(root.right)<=0){
            return leftRotate(root);
        }

        //RL
        if(balance<-1 && getBalance(root.right)>0){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    //Inorder Traversal
    void inorder(Nodeavld node){
        if(node!=null){
            inorder(node.left);
            System.out.print(node.data+" ");
            inorder(node.right);
        }
    }



}
public class AVLDeleteNode {

    public static void main(String[] args){

        AVLDTree tree=new AVLDTree();
        Nodeavld root=null;

        //Insert nodes
        root=tree.insert(root, 30);
        root=tree.insert(root, 20);
        root=tree.insert(root, 40);
        root=tree.insert(root, 10);
        root=tree.insert(root, 25);
        root=tree.insert(root, 50);
        root=tree.insert(root, 5);

        System.out.println("Inorder Traversal Before Deletion: ");
        tree.inorder(root);

        //Delete node
        root=tree.delete(root, 20);

        System.out.println("\nInorder Traversal After Deletion: ");
        tree.inorder(root);
    }
}
