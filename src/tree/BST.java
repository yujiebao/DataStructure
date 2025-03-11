package tree;

import 集合和映射.Set;

import javax.swing.*;
//binary search tree 二分搜索树
public class BST<E> implements Set<E> {
    private class Node
    {
        Node left,right;
        E e;
    }

    private Node root;
    private int size;

    BST()
    {

    }

    @Override
    public void add(E e) {

    }

    @Override
    public void remove(E e) {

    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
