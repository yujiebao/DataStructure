package 队列;

import 数组.Array;
import 数组.GenericArray;

public class Arrayqueue<E> implements Queue<E> {
    private GenericArray<E> array;
    public Arrayqueue(int capacity)
    {
        array = new GenericArray<>(capacity);
    }
    public  Arrayqueue()
    {
        array = new GenericArray<>();
    }
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity()
    {
        return array.getCapacity();
    }

    @Override
    public  String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return  res.toString();
    }
}
