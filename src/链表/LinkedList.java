package 链表;

import java.util.Currency;

public class LinkedList<E> {
    /**
     * 内部类  不需要外部访问
     **/
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //    private Node head;
    private Node dummyHead;//头结点无数据
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        //无头结点
//       Node node = new Node(e);
//       node.next = head;
//       head = node;
//         head = new Node(e,head);
//
//       size++;

        //有头结点
        add(0, e);
    }

    //在链表的index位置添加元素     不常用
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)  //有头结点
        {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;

    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e)
    {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("二分搜索树.Set failed");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e)
    {
        Node cur = dummyHead.next;
        while (cur != null)
        {
            if(cur.e == e)
            {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void removeElement(E e)
    {
        Node cur = dummyHead;
//        while (true) {
//            if (cur.next.e.equals(e)) {
//                cur.next = cur.next.next;
//                size--;
//                return;
//            }
//            cur = cur.next;
//        }
          while (cur.next != null)
          {
              if(cur.next.e.equals(e))
                  break;
              cur = cur.next;
          }
        if(cur.next != null){
            Node delNode = cur.next;
            cur.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null)
        {
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public E remove(int index)
    {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed");
        }

        Node prev = dummyHead;
        for(int i = 0;i < index; i++)
        {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeFirst()
    {
        return remove(0);
    }

    public E removeLast()
    {
       return remove(size-1);
    }
}
