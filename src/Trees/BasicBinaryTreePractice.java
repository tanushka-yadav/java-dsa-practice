package Trees;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data=data;
        left=null;
        right=null;

    }
}
public class BasicBinaryTreePractice {

    TreeNode root;

    //Create Sample Tree
    public void createTree(){

        root=new TreeNode(10);

        root.left=new TreeNode(20);
        root.right=new TreeNode(30);

        root.left.left=new TreeNode(40);
        root.left.right=new TreeNode(50);

        root.right.left=new TreeNode(60);
        root.right.right=new TreeNode(70);
    }

    //Preorder Traversal
    public void preorder(TreeNode node){

        if(node == null)
            return;

        System.out.print(node.data+" ");

        preorder(node.left);
        preorder(node.right);
    }

    //Inorder Traversal
    public void inorder(TreeNode node){

        if(node==null)
            return;

        inorder(node.left);

        System.out.print(node.data+" ");

        inorder(node.right);
    }

    //Postorder Traversal
    public void postorder(TreeNode node){

        if(node==null)
            return;

        postorder(node.left);
        postorder(node.right);

        System.out.print(node.data+" ");
    }

    //Count Nodes
    public int countNodes(TreeNode node){

        if(node==null)
            return 0;

        return 1 + countNodes(node.left)+countNodes(node.right);
    }

    //Count Leaf Nodes
    public int countLeafNodes(TreeNode node){

        if(node==null)
            return 0;

        if(node.left==null && node.right==null)
            return 1;

        return countLeafNodes(node.left)+countLeafNodes(node.right);
    }

    //Height of Tree
    public int height(TreeNode node){

        if(node == null)
            return 0;

        int leftHeight=height(node.left);
        int rightHeight=height(node.right);

        return Math.max(leftHeight, rightHeight)+1;
    }

    //Search Node
    public boolean search(TreeNode node, int value){

        if(node==null)
            return false;

        if(node.data==value)
            return true;

        return search(node.left, value) || search(node.right, value);
    }

    public static void main(String[] args){

        BasicBinaryTreePractice tree=new BasicBinaryTreePractice();

        tree.createTree();

        System.out.print("Binary Tree Created Successfully");

        System.out.print("\nPreorder Traversal: ");
        tree.preorder(tree.root);

        System.out.print("\nInorder Traversal: ");
        tree.inorder(tree.root);

        System.out.print("\nPostorder Traversal: ");
        tree.postorder(tree.root);

        System.out.println("\n\nTotal Nodes: "+tree.countNodes(tree.root));

        System.out.println("Leaf Nodes: "+tree.countLeafNodes(tree.root));

        System.out.println("Height of Tree: "+tree.height(tree.root));

        int searchValue=50;

        if(tree.search(tree.root, searchValue))
            System.out.println(searchValue+" Found in Tree");
        else
            System.out.println(searchValue+" Not Found");
    }
}
