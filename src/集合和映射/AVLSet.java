package 集合和映射;

import 平衡树和AVL.AVLTree;

public class AVLSet<E extends Comparable<E>> implements Set<E> {

    private AVLTree<E,Object> avl;

    public AVLSet()
    {
        avl = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avl.add(e,null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
