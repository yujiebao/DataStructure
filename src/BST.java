
//建立和使用二分搜索树

import java.util.zip.CheckedOutputStream;

public class BST<E extends Comparable<E>> {
    public Node root = null;
    private class Node
    {
        E data;
        Node left,right;
        Node(E data)
        {
            this.data = data;
            left = null;
            right = null;
        }

        Node(Node node,E data)
        {
            left = node;
            this.data = data;
            right = null;
        }

        Node(E data,Node node)
        {
            left = null;
            this.data = data;
            right = node;
        }
        Node(Node leftNode,E data,Node rightNode)
        {
            left = leftNode;
            this.data = data;
            right = rightNode;
        }
    }
    public  void Init(E data)
    {
        if (root == null)
            root = new Node(data);
        else
        {
            System.out.println("已经建立了树");
        }
    }

    public void  addData(E data)
    {
        addData(root,data);
    }

    //node指示添加数据的树（包括子树）
    private Node addData(Node node , E data)
    {
        if (node == null)
           return new Node(data);
        if (data.compareTo(node.data) < 0)
        {
           node.left = addData(node.left,data);
        }
        else if (data.compareTo(node.data) > 0)
        {
           node.right = addData(node.right,data);
        }

        return node;
    }

    public void preOrder()
    {
        preOrder(root);
    }

    private void preOrder(Node node)
    {
        if (node == null)
            return;

        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder()
    {
        inOrder(root);
    }

    private void inOrder(Node node)
    {
        if (node == null)
            return;

        preOrder(node.left);
        System.out.println(node.data);
        preOrder(node.right);
    }

    public void postOrder()
    {
        postOrder(root);
    }

    private void postOrder(Node node)
    {
        if (node == null)
            return;

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        BST<Integer> tree = new BST<Integer>();
        tree.Init(10);
        for (int i = 5;i< 16;i++)
        {
            tree.addData(i);
        }
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();

    
    }
}
