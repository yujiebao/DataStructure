package 集合和映射;

import 链表.LinkedList;

import java.util.regex.Pattern;

public class LinkedListMap<K,V> implements Map<K,V>  {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key ,V value,Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key)
        {
//            this.key = key;
//            this.value = null;
//            this.next = null;
            this(key,null,null);
        }

        public Node()
        {
            this(null,null,null);
        }

        @Override
        public  String toString()
        {
            return key.toString()+":" +value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap()
    {
        dummyHead = new Node();
        size = 0 ;
    }

    private Node getNode(K key)
    {
        Node cur = dummyHead.next;
        while (cur != null)
        {
            if (cur.key == key)   //比较到没有元素，最后一个比较的后继结点为null
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null)
        {
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }
        else
            node.value = value;
    }

    @Override
    public V remove(K key) {
        Node cur = dummyHead;

        while (cur.next != null)
        {
            if(cur.next.key.equals(key))
                break;
            cur = cur.next;
        }
        if(cur.next != null){
            Node delNode = cur.next;
            cur.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return  null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!= null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null)
            throw new  IllegalArgumentException(key+"doesn't exist");
        node.value = value;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
}
