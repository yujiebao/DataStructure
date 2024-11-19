package 集合和映射;

import 链表.LinkedList;

public class LinkListSet<E> implements Set<E> {

    private LinkedList<E> List;
    LinkListSet()
    {
        List = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!List.contains(e))
            List.addFirst(e);   //O(1)

    }

    @Override
    public void remove(E e) {
        List.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return List.contains(e);
    }

    @Override
    public int getSize() {
        return List.getSize();
    }

    @Override
    public boolean isEmpty() {
        return List.isEmpty();
    }

    @Override
    public String toString()
    {
        return List.toString();
    }
}
