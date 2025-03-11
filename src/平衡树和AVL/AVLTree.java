package 平衡树和AVL;

import 二叉树.BST;
import 数组.Array;
import 集合和映射.Map;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>,V> implements Map<K,V> {

    private class Node
    {
        private K key;
        private V value;
        private Node left,right;
        private int height;

        public Node(K key,V value)
        {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            height = 1;
        }
    }

    private  Node root;
    private int size;


    public AVLTree()
    {
        root = null;
        size = 0;
    }

    private int getHeight(Node node)
    {
        if (node == null)
            return 0;
        return node.height;
    }

    private int getBalanceFactor(Node node)
    {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }


    private  Node add( Node node, K Key, V value)
    {
        if (node == null)
        {
            size++;
            return new Node(Key,value);
        }
        if (Key.compareTo(node.key)<0)
            node.left = add(node.left, Key,value);
        else if (Key.compareTo(node.key)>0)
            node.right = add(node.right,Key,value);
        else
            node.value = value;

        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);
//        if (Math.abs(balanceFactor) > 1)
//            throw new IllegalArgumentException("Unbalanced");

        //平衡维护
        //balancedFactor > 1  ---->左侧高度大于右侧   getBalanceFactor(node.left) >=0  ---->  左侧的左侧多  LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >=0)
            return rightRotate(node);
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)  //RR
            return leftRotate(node);
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) //LR
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0)//RL
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
//未处理相等情况，直接跳过不处理
        return  node;
    }

//对y进行右旋 y为不平衡的节点
    private Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T3 = x.right;

        //旋转
        x.right = y;
        y.left = T3;

        //新的高度
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;

        return x;
    }

    private Node leftRotate(Node y)
    {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;

        return x;
    }

    private Node getNode(Node node, K key)
    {
        if (node == null)
            return null;

        if (key.equals(node.key))
            return node;
        if (key.compareTo(node.key) < 0)
            return getNode(node.left,key);
        else
            return getNode(node.right,key);
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if (node != null)
        {
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node , K key)
    {
        if(node == null)
            return null;

        Node retNode ;  //存储删除后返回的Node  都用retNode存储便于判断
        if (key.compareTo(node.key) < 0)
        {
            node.left = remove(node.left,key);
            retNode =node;
        }
        else if(key.compareTo(node.key) > 0)
        {
            node.right = remove(node.right,key);
            retNode = node;
        }
        else   //e == node.e
        {
            //左子树为空
            if(node.left == null)
            {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            }
            //右子树为空
            else if(node.right == null)
            {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            }
            else
            {//待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = mininum(node.right);
//            successor.right = removeMin(node.right);   //此操作进行了长度减一所以不用减
            successor.right = remove(node.right,successor.key);
//                size++;
            successor.left = node.left;

            node.left = node.right = null;
//                size--;
            retNode = successor;
            }

        }
        if (retNode == null)
            return null;
        retNode.height = Math.max(getHeight(retNode.left),getHeight(retNode.right))+1;
        int balanceFactor = getBalanceFactor(retNode);
        //平衡维护
        //balancedFactor > 1  ---->左侧高度大于右侧   getBalanceFactor(node.left) >=0  ---->  左侧的左侧多  LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >=0)
            return rightRotate(retNode);
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)  //RR
            return leftRotate(retNode);
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) //LR
        {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0)//RL
        {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;

    }

    private Node mininum(Node node)
    {
        if (node.left == null)
            return node;
        return mininum(node.left);
    }

    private Node removeMin(Node node)
    {
        if (node.left == null)   //说明node是最左的元素
        {
            Node rightNode = node.right;   //righNode指向原node.right的堆空间的地址
            // 此时有rightNode和node.right同时指向node.right的堆空间
            node.right = null;              //相当于去除node的右孩子
            size--;
            return rightNode;               //将当前的右子树单做是新的树，去除了传入的node为根的根节点
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node == null? null : node.value;
    }

    public boolean isBalanced()
    {
        return isBalanced(root);
    }


    public boolean isBalanced(Node node)
    {
        if (node == null)
            return true;

        int balancedFactor = getBalanceFactor(node);
        if (Math.abs(balancedFactor) > 1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    public boolean isBST()
    {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root,keys);
        for (int i = 0; i < keys.size()-1; i++)
        {
            if (keys.get(i).compareTo(keys.get(i+1)) > 0)
                return false;
        }
        return true;
    }

    private void inOrder(Node node , ArrayList<K> keys)
    {
        if (node == null)
            return;

        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root,key);
        if (node == null)
            throw new IllegalArgumentException(key+" doesn't exist!");

        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void  generateBSTString( Node node , int depth , StringBuilder res)
    {
        if(node == null) {
            res.append(generateBSTString(depth)+"null\n");
            return;
        }

        res.append(generateBSTString(depth)+node.key+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String  generateBSTString(int depth)
    {
        StringBuilder res = new StringBuilder();
        for(int i = 0 ;i < depth;i++)
        {
            res.append("--");
        }
        return res.toString();
    }
}