package Trie;


import java.util.TreeMap;
public class Trie {
     private class Node
     {
        public boolean isWord;
        public TreeMap<Character,Node> next;

        Node(boolean isWord)
        {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        Node()
        {
            this(false);
        }
    }
    private Node root;
    private int size;
    public Trie()
    {
        root = new Node();
        size = 0;
    }

    public int getSize()
    {
        return size;
    }

    public void add(String word)
    {
        Node cur = root;
        for (int i = 0 ; i < word.length() ; i++)
        {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
            {
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord)
        {
            cur.isWord = true;
            size++ ;
        }
    }

    public boolean contains(String word)
    {
         Node cur = root;
         for (int i = 0 ; i < word.length(); i++)
         {
             if (cur.next.get(word.charAt(i)) != null)
             {
                 cur = cur.next.get(word);
             }
             else
                 return false;
         }
         return cur.isWord;
    }

    public boolean isPrefix(String prefix)
    {
        Node cur = root;
        for (int i = 0 ; i < prefix.length(); i++)
        {
            if (cur.next.get(prefix.charAt(i)) != null)
            {
                cur = cur.next.get(prefix);
            }
            else
                return false;
        }
        return true;
    }
}
