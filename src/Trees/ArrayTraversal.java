package Trees;

public class ArrayTraversal {

    public static class ArrayNode{
        String data;
        ArrayNode left;
        ArrayNode right;

        public ArrayNode(String data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static void postOrderTraversal(ArrayNode node){
        if(node==null){
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data+", ");
    }

    public static void main(String[] args){
        ArrayNode root=new ArrayNode("R");
        ArrayNode nodeA=new ArrayNode("A");
        ArrayNode nodeB=new ArrayNode("B");
        ArrayNode nodeC=new ArrayNode("C");
        ArrayNode nodeD=new ArrayNode("D");
        ArrayNode nodeE=new ArrayNode("E");
        ArrayNode nodeF=new ArrayNode("F");
        ArrayNode nodeG=new ArrayNode("G");

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
