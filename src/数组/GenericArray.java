package 数组;

import java.util.Objects;

public class GenericArray<T> {
    private  T[] data;
    private  int size;
    //传入数组的容量
    public GenericArray(int capacity)
    {
        data = (T[])new Object[capacity];//构建T类型数组
        size = 0;
    }

    //无参数
    public GenericArray()
    {
        this(10);
    }

    //获取数组的元素个数
    public int getSize()
    {
        return  size;
    }

    //获取数组的容量
    public int getCapacity()
    {
        return data.length;
    }

    public  boolean isEmpty()
    {
        return size == 0;
    }

    public  void addLast(T e)
    {
//        if(size == data.length)
//        {
//           throw  new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//        data[size] = e;
//        size++;
        add(size,e);
    }
    public  void addFirst(T e)
    {
        add(0,e);
    }

    //    public  void add(int index, int e)
//    {
//        if(size == data.length)
//        {
//            throw  new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//        if(index < 0 || index>size)
//        {
//            throw  new IllegalArgumentException("error");
//        }
//        for(int i = 0;i <=size-index;i++)
//        {
//          data[size-i] = data[size-1-i];
//        }
//        data[index-1] = e;
//        size++;
//    }
    public  void add(int index, T e)
    {
        if(size == data.length)
        {
//            throw  new IllegalArgumentException("AddLast failed. Array is full.");
              resize(2*data.length);
        }
        if(index < 0 || index>size)
        {
            throw  new IllegalArgumentException("error");
        }
        for(int i = size-1;i>= index;i--)
        {
            data[i+1]= data[i];
        }
        data[index] = e;
        size++;
    }

    public  void show()
    {
        for(int i = 0 ; i < size ;i++ )
            System.out.println(data[i]);
    }

    @Override
    public  String toString()
    {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
        res.append('[');
        for(int i = 0; i <size ; i++)
        {
            res.append(data[i]);
            if(i != size - 1)
            {
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }

    public T get(int index)
    {
        if(index < 0 || index >=size)
        {
            throw new IllegalArgumentException("Get failed");
        }
        return data[index];
    }

    public void set(int index , T e)
    {
        if(index < 0 || index >=size)
        {
            throw new IllegalArgumentException("二分搜索树.Set failed");
        }
        data[index] = e;
    }

    public boolean contains(T e)
    {
//        for(int i = 0;i<size;i++)
//        {
//            if(data[i] == e)
//                return true;
//        }
//        return false;
        return find(e)!=-1;
    }

    public int find(T e)
    {
        for(int i = 0;i<size;i++)
        {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    public T remove(int index)
    {
        if(index < 0||index >size)
        {
            throw new IllegalArgumentException("Remove failed");
        }
        T res = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if(size == data.length/4&&data.length/2!=0)
        {
            resize(data.length/2);
        }
        return res;
    }

    public  T removeLast()
    {
        return remove(size);
    }

    public  T removeFirst()
    {
        return remove(0);
    }

    public int delete(T e)
    {
//        int place = find(e);
//        if(contains(e)) {
//            for (int i = find(e); i < size - 1; i++) {
//                data[i] = data[i + 1];
//            }
//            size--;
//            return place;
//        }
//        else
//        {
//           throw new IllegalArgumentException("Don't have this  data");
//        }
        remove(find(e));
        return  find(e);
    }
    private void resize(int newCapacity)
    {
        T[] newData = (T[])new Object[newCapacity];
        for(int i = 0; i <size;i++)
        {
            newData[i] = data[i];
        }
        data = newData;
    }
}
