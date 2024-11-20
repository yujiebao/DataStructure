package 数组;
/**
 * 构建自己的数组类
 * */
public class Array{
    private  int[] data;
    private  int size;
    //传入数组的容量
    public Array(int capacity)
    {
        data = new int[capacity];
        size = 0;
    }

    //无参数
    public Array()
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

    public  void addLast(int e)
    {
//        if(size == data.length)
//        {
//           throw  new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//        data[size] = e;
//        size++;
        add(size,e);
    }
    public  void addFirst(int e)
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
     public  void add(int index, int e)
     {
        if(size == data.length)
        {
            throw  new IllegalArgumentException("AddLast failed. Array is full.");
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

    public int get(int index)
    {
        if(index < 0 || index >=size)
        {
            throw new IllegalArgumentException("Get failed");
        }
        return data[index];
    }

    public void set(int index , int e)
    {
        if(index < 0 || index >=size)
        {
            throw new IllegalArgumentException("二分搜索树.Set failed");
        }
        data[index] = e;
    }

    public boolean contains(int e)
    {
//        for(int i = 0;i<size;i++)
//        {
//            if(data[i] == e)
//                return true;
//        }
//        return false;
        return find(e)!=-1;
    }

    public int find(int e)
    {
        for(int i = 0;i<size;i++)
        {
            if(data[i] == e)
                return i;
        }
        return -1;
    }

    public int remove(int index)
    {
        if(index < 0||index >size)
        {
            throw new IllegalArgumentException("Remove failed");
        }
        int res = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return res;
    }

    public int delete(int e)
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
//            throw new IllegalArgumentException("Don't have this  data");
//        }
        remove(find(e));
        return  find(e);
    }


}
