package 栈;
import 数组.GenericArray;

public class ArrayStack<E> implements Stack<E> {
    GenericArray<E> array;
    public ArrayStack(int capacity)
    {
        array = new GenericArray<>(capacity);
    }
    public  ArrayStack()
    {
        array = new GenericArray<>();
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
    public void push(E e) {
      array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.get(array.getSize()-1);
    }

    @Override
    public  String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return  res.toString();
    }
}
