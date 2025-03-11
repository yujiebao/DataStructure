package 二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import java.io.PushbackInputStream;
import java.text.SimpleDateFormat;

//*
// 此树种不能包含重复元素
// *//
public class BST<E extends Comparable<E>> {
    private  class Node{
        private E e;
        private Node left, right;

        Node(E e)
        {
            this.e = e;
            left = null;
            right = null;
        }
    }

        private Node root;
        private int size;
        BST()
        {
            root = null;
            size = 0;
        }

        public int getSize()
        {
            return size;
        }

        public boolean isEmpty()
        {
            return size == 0;
        }

        public void add(E e)
        {
//            if(root == null)
//            {
//                root = new Node(e);
//                size++;
//            }
//            else
//            {
//                add(root,e);
//            }
              root = add(root,e);//必须为root赋值，否者root一直为空
        }

//        private void  add(Node node,E e)
//        {
//            if(e.equals(node.e))
//            {
//                return;
//            }
//            else if(e.compareTo(node.e) < 0 && node.left == null)
//            {
//                node.left = new Node(e);
//                size++;
//                return;
//            }
//            else if(e.compareTo(node.e) > 0 && node.right == null)
//            {
//                node.right = new Node(e);
//                size++;
//                return;
//            }
//
//            if (e.compareTo(node.e)<0)
//                add(node.left, e);
//            else
//                add(node.right,e);
//        }

        private Node add(Node node,E e)
        {
           if (node == null)
           {
               size++;
               return new Node(e);
           }
            if (e.compareTo(node.e)<0)
                node.left = add(node.left, e);
            else if (e.compareTo(node.e)>0)
                node.right = add(node.right,e);
//未处理相等情况，直接跳过不处理
            return  node;
        }

        public boolean contains(E e)
        {
            return contains(root,e);
        }

        private  boolean contains(Node node,E e)
        {
            if(node == null)
                return  false;
            if (e.compareTo(node.e) == 0)
                return  true;
            else if (e.compareTo(node.e) < 0)
                return contains(node.left,e);
            else
                return contains(node.right,e);
        }

        public void preOrder()
        {
            preOrder(root);
        }

        private void preOrder(Node node)
        {
            if (node == null)
                return;

            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }

        public void preOrderNR()
        {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty())
            {
                Node cur = stack.pop();
                System.out.println(cur.e);

                if(cur.right != null)
                stack.push(cur.right);
                if(cur.left != null)
                stack.push(cur.left);

            }
        }

        public void inOrder()
        {
            inOrder(root);
        }

        private void inOrder(Node node)
        {
            if (node == null)
                return;

            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }


        public void postOrder()
        {
            //为二叉树释放内存 先处理孩子节点，再处理父亲节点
            postOrder(root);
        }

        public void postOrder(Node node)
        {
            if (node == null)
                return;

            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }

        public void levelOrder()
        {
            //广度优先
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty())
            {
                Node cur = q.remove();
                System.out.println(cur.e);

                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
        }




        public E removeMin()
        {
            E ret = mininum();
            root = removeMin(root);
            return ret;
        }

        //删除掉以node为根的二分搜索树中的最小节点
        // 返回删除节点后新的二分搜索树的根
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

        public E removeMax()
        {
            E ret = maxinum();
            root = removeMax(root);
            return ret;
        }


        private Node removeMax(Node node)
        {
            if (node.right == null)
            {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

           node.right = removeMax(node.right);
            return node;
        }

        public E mininum()
        {
            if(size == 0)
                throw new IllegalArgumentException("BST is empty");

            return mininum(root).e;
    }

        private Node mininum(Node node)
        {
            if (node.left == null)
                return node;
            return mininum(node.left);
        }

        public E maxinum()
        {
            if(size == 0)
                throw new IllegalArgumentException("BST is empty");

            return maxinum(root).e;
        }

        private Node maxinum(Node node)
        {
            if (node.right == null)
                return node;
            return maxinum(node.right);
        }

        public void remove(E e)
        {
            remove(root,e);
        }

        private Node remove(Node node , E e)
        {
            if(node == null)
                return null;
            if (e.compareTo(node.e) < 0)
            {
                node.left = remove(node.left,e);
                return node;
            }
            else if(e.compareTo(node.e) > 0)
            {
                node.right = remove(node.right,e);
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
        @Override
        public String toString()
        {
            StringBuilder res = new StringBuilder();
            generateBSTString(root,0,res);
            return res.toString();
        }

        private void  generateBSTString(Node node ,int depth , StringBuilder res)
        {
            if(node == null) {
                res.append(generateBSTString(depth)+"null\n");
                return;
            }

            res.append(generateBSTString(depth)+node.e+"\n");
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


//        floor ceil ;     rank   select   ;

}
