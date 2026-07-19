package Trees;

public class DSAPostOrder {

    public static class PostOrder{
        String data;
        PostOrder left;
        PostOrder right;

        public PostOrder(String data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static void postOrderTraversal(PostOrder node){
        if(node==null){
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data+", ");
    }

    public static void main(String[] args){
        PostOrder root=new PostOrder("R");
        PostOrder nodeA=new PostOrder("A");
        PostOrder nodeB=new PostOrder("B");
        PostOrder nodeC=new PostOrder("C");
        PostOrder nodeD=new PostOrder("D");
        PostOrder nodeE=new PostOrder("E");
        PostOrder nodeF=new PostOrder("F");
        PostOrder nodeG=new PostOrder("G");

        root.left=nodeA;
        root.right=nodeB;

        nodeA.left=nodeC;
        nodeA.right=nodeD;

        nodeB.left=nodeE;
        nodeB.right=nodeF;

        nodeF.left=nodeG;

        //Traverse
        postOrderTraversal(root);
    }
}
