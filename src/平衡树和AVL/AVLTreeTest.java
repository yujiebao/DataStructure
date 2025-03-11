package 平衡树和AVL;

import java.util.Random;

public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree<Integer ,Integer > avlTree = new AVLTree();
        for (int i = 0; i < 10 ; i++)
           {
               avlTree.add(i,i);
           }
        String a =avlTree.toString();
        System.out.println(a);
        System.out.println();
        System.out.println();
        avlTree.remove(1);
        avlTree.remove(2);
        a = avlTree.toString();
        System.out.println(a);
        System.out.println(avlTree.isBalanced());
    }
}
