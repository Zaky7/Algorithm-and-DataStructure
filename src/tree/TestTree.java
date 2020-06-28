package tree;

public class TestTree {

  public static void main(String[] args) {
    BinaryTree<Integer> bTree = new BinaryTree<>();
    Integer[] arr = { 1, 2, 3, 5, 7, 4, 9 };

    for (Integer i : arr) {
      bTree.addNodeLevelOrderWise(i);
    }

    Node<Integer> root = bTree.root();
    //        bTree.printPreOrder(root);
    //        System.out.println();

    //        bTree.printPreOrderRecursive(root);

    bTree.printPostOrderIterative(root);
    //        bTree.printInOrder(root);
    //        System.out.println();
    //        bTree.printPostorder(root);
    //        System.out.println();

  }
}
