package 队列;

import javax.xml.validation.TypeInfoProvider;

//循环队列
public class LoopQueue<E> implements Queue<E>
{
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity)
    {
        data =(E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public  LoopQueue()
    {
        this(10) ;
    }

    public int getCapacity()
    {
        return data.length-1;
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length == front)
        {
            resize(2*getCapacity());
        }
        data[tail] = e ;
        tail = (tail+1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
        {
            throw new IllegalArgumentException("Queue is empty. cannot dequeue");
        }

        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;

        if(size == getCapacity()/4 && getCapacity()/2 != 0)
        {
            resize(getCapacity()/2);
        }

        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
        {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    private void resize(int newCapacity)
    {
        E[] newData = (E[])new Object[newCapacity+1];
        for(int i = 0 ; i < size; i++)
            newData[i] = data[(front+i)%data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public  String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n",size,getCapacity()));
        res.append("Queue: ");
        res.append("front [");
        for (int i = front; i != tail; i=(i + 1)%data.length) {
            res.append(data[i]);
            if ((i+1)%data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return  res.toString();
    }
}
