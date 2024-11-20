package 二叉树;

public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(41);
        tree.add(58);
        tree.add(50);
        tree.add(60);
        tree.add(42);
        tree.add(53);
        tree.add(59);
        tree.add(63);
//        System.out.println(tree.getSize());
//        tree.preOrder();
//        System.out.println();
//        tree.preOrderNR();
//          tree.levelOrder();
//        System.out.println();
//        tree.inOrder();
//        tree.postOrder();
//        System.out.println(tree);
//        tree.removeMin();
//        System.out.println(tree);
        System.out.println(tree);
//        tree.removeMax();
//        tree.removeMax();
        tree.remove(58);
        System.out.println(tree);
//        System.out.println(tree.mininum());
//        System.out.println(tree.maxinum());

        BSTMap<Integer,Integer> map = new BSTMap<>();
        for (int i = 0 ; i < 10; i++)
        {
            if (map.contains(i))
                map.set(i,map.get(i)+1);
            else
                map.add(i,1);
        }


        for (int i = 5 ; i < 10; i++)
        {
            if (map.contains(i))
                map.set(i,map.get(i)+1);
            else
                map.add(i,1);
        }
        System.out.println(map.get(9));
        System.out.println(map.get(0));

    }
}
