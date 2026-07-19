public static class DSAInOrderTraversal {
    String data;
    DSAInOrderTraversal left;
    DSAInOrderTraversal right;

    public DSAInOrderTraversal(String data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public static void inOrderTraversal(DSAInOrderTraversal node){

    if(node==null){
        return;
    }
    inOrderTraversal(node.left);
    System.out.print(node.data+", ");
    inOrderTraversal(node.right);
}

public static void main(String[] args){
    DSAInOrderTraversal root=new DSAInOrderTraversal("R");
    DSAInOrderTraversal nodeA=new DSAInOrderTraversal("A");
    DSAInOrderTraversal nodeB=new DSAInOrderTraversal("B");
    DSAInOrderTraversal nodeC=new DSAInOrderTraversal("C");
    DSAInOrderTraversal nodeD=new DSAInOrderTraversal("D");
    DSAInOrderTraversal nodeE=new DSAInOrderTraversal("E");
    DSAInOrderTraversal nodeF=new DSAInOrderTraversal("F");
    DSAInOrderTraversal nodeG=new DSAInOrderTraversal("G");

    root.left=nodeA;
    root.right=nodeB;

    nodeA.left=nodeC;
    nodeA.right=nodeD;
    nodeB.left=nodeE;
    nodeB.right=nodeF;
    nodeF.left=nodeG;

    //Traverse
    inOrderTraversal(root);
}
