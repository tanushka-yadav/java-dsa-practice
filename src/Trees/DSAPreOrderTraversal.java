package Trees;

public class DSAPreOrderTraversal {

    public static class PreOrderTraversal{
        String data;
        PreOrderTraversal left;
        PreOrderTraversal right;

        public PreOrderTraversal(String data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static void preOrderTraversal(PreOrderTraversal node){
        if(node==null){
            return;
        }
        System.out.print(node.data+", ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void main(String[] args){
        PreOrderTraversal root=new PreOrderTraversal("R");
        PreOrderTraversal nodeA=new PreOrderTraversal("A");
        PreOrderTraversal nodeB=new PreOrderTraversal("B");
        PreOrderTraversal nodeC=new PreOrderTraversal("C");
        PreOrderTraversal nodeD=new PreOrderTraversal("D");
        PreOrderTraversal nodeE=new PreOrderTraversal("E");
        PreOrderTraversal nodeF=new PreOrderTraversal("F");
        PreOrderTraversal nodeG=new PreOrderTraversal("G");

        root.left=nodeA;
        root.right=nodeB;

        nodeA.left=nodeC;
        nodeA.right=nodeD;

        nodeB.left=nodeE;
        nodeB.right=nodeF;

        nodeF.left=nodeG;

        //Traverse
        preOrderTraversal(root);

    }
}
