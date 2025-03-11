package 红黑树;

import java.util.TreeMap;

public class RBTree<K extends Comparable<K>,V>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node
    {

        private K key;
        private V value;
        private Node left,right;
        private boolean color;

        public Node(K key,V value)
        {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            color = RED;    //添加节点先融合，可能为3节点或者4节点
        }
    }

    private Node root;
    private int size;


    public RBTree()
    {
        root = null;
        size = 0;
    }


//    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
        root.color = BLACK;
    }

    private boolean isRed(Node node){
        if(node == null)
            return BLACK;
        return node.color;
    }

    private Node leftRotate(Node node)
    {
        Node x = node.right;

        //做旋转
        node.right = x.left;
        x.left = node;

        //维护颜色
        x.color = node.color;
        node.color = RED;

        return x ;
    }

    private Node rightRotate(Node node)
    {
         Node x = node.left;
         x.right = node;

         x.color = node.color;
         node.color = RED;

         return x;
    }


    //a红 b黑 c红   --->四节点
    private void flipColors(Node node)
    {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

//向node为根的红黑树中插入元素(key,value)
//返回插入新节点后红黑树的根
    private Node add(Node node, K Key,V value)
    {
        if (node == null)
        {
            size++;
            return new Node(Key,value);  //默认为红节点
        }
        if (Key.compareTo(node.key)<0)
            node.left = add(node.left, Key,value);
        else if (Key.compareTo(node.key)>0)
            node.right = add(node.right,Key,value);
        else
            node.value = value;

        if (isRed(node.right)&&!isRed(node.left))
            node = leftRotate(node);
        if (isRed(node.left)&&isRed(node.left.left))
            node = rightRotate(node);
        if (isRed(node.left)&&isRed(node.right))
            flipColors(node);
        return  node;
    }



    private Node getNode(Node node,K key)
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

//    @Override
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
            if (key.compareTo(node.key) < 0)
            {
                node.left = remove(node.left,key);
                return node;
            }
            else if(key.compareTo(node.key) > 0)
            {
                node.right = remove(node.right,key);
                return node;
            }
            else   //e == node.e
            {
                //左子树为空
                if(node.left == null)
                {
                    Node rightNode = node.right;
                    node.right = null;
                    size--;
                    return rightNode;
                }
                //右子树为空
                if(node.right == null)
                {
                    Node leftNode = node.left;
                    node.left = null;
                    size--;
                    return leftNode;
                }

                //待删除节点左右子树均不为空的情况
                // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = mininum(node.right);
                successor.right = removeMin(node.right);   //此操作进行了长度减一所以不用减
//                size++;
                successor.left = node.left;

                node.left = node.right = null;
//                size--;
                return  successor;
            }

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

//    @Override
//    public boolean contains(K key) {
//        return getNode(root,key) != null;
//    }
//
//    @Override
//    public V get(K key) {
//        Node node = getNode(root,key);
//        return node == null? null : node.value;
//    }
//
//    @Override
//    public void set(K key, V value) {
//        Node node = getNode(root,key);
//        if (node == null)
//            throw new IllegalArgumentException(key+" doesn't exist!");
//
//        node.value = value;
//    }
//
//    @Override
//    public int getSize() {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }
}
