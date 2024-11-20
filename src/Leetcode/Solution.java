package Leetcode;

import java.util.TreeMap;

class Solution {

    private class Freq implements Comparable<Freq>{
        public int e, freq;

        public Freq(int e , int freq)
        {
            this.e = e;
            this.freq = freq;
        }
        @Override
        public int compareTo(Freq freq) {
            return freq.e - e;
        }
    }



    private class GenericArray<T> {
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

        public GenericArray(T[] arr)
        {
            data = (T[]) new Object[arr.length];
            for (int i = 0 ; i< arr.length; i++)
            {
                data[i] = arr[i];
            }
            size = arr.length;

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

        public void swap(int i ,int j)
        {
            if (i < 0 || i >= size || j >= size)
                throw new IllegalArgumentException("Index illegal");

            T t = data[i];
            data[i] = data[j];
            data[j] = t ;
        }
    }

    private class MaxHeap<E extends Comparable<E>> {
        private GenericArray<E> data;

        public MaxHeap(int capacity)
        {
            data = new GenericArray<>(capacity);
        }

        public MaxHeap()
        {
            data = new GenericArray<>();
        }

        public MaxHeap(E[] arr)
        {
            data = new GenericArray<>(arr);
            for (int i = parent(arr.length-1);i >= 0;i--)
            {
                siftDown(i);
            }
        }

        public int size(){
            return data.getSize();
        }
        public boolean isEmpty()
        {
            return data.isEmpty();
        }

        private int parent(int index)
        {
            if (index == 0)
                throw new IllegalArgumentException("index-0 doesn't hava parent.");
            return (index-1)/2;
        }

        private int leftChild(int index)
        {
            return 2*index+1;
        }

        private int rightChild(int index)
        {
            return 2*index+2;
        }

        public void add(E e)
        {
            data.addLast(e);
            siftUp(data.getSize()-1);
        }


        public E extractMax()
        {
            E ret = findMax();

            data.swap(0,data.getSize()-1);
            data.removeLast();
            siftDown(0);
            return ret;
        }

        public E findMax()
        {
            if (data.getSize() == 0)
                throw new IllegalArgumentException("Can not findMax When heap is empty");
            return data.get(0);
        }

        private void siftUp(int i) {
            while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0)
            {
                data.swap(i,parent(i));
                i = parent(i);
            }
        }

        private void siftDown(int i)
        {
            while (leftChild(i) < data.getSize())  //已经没有孩子节点了
            {
                int j = leftChild(i);
                if (j+1 < data.getSize() && data.get(j+1).compareTo(data.get(j))>= 0)
                    j = rightChild(i);   //j中是i左右孩子中最大的值
                if (data.get(i).compareTo(data.get(j)) >= 0 )
                    break;
                data.swap(i,j);
                i = j;   //判断是否需要继续下沉
            }
        }

        public E replace(E e)
        {
            E ret = findMax();
            data.set(0,e);
            siftDown(0);
            return ret;
        }


    }


    private class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

        private MaxHeap<E> maxHeap;

        @Override
        public void enqueue(E e) {
            maxHeap.add(e);
        }

        @Override
        public E dequeue() {
            return maxHeap.extractMax();
        }

        @Override
        public E getFront() {
            return maxHeap.findMax();
        }

        @Override
        public int getSize() {
            return maxHeap.size();
        }

        @Override
        public boolean isEmpty() {
            return maxHeap.isEmpty();
        }
    }


    private interface Queue<E> {
        void enqueue(E e);
        E dequeue();
        E getFront();
        int getSize();
        boolean isEmpty();
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key : map.keySet())
        {
            if (pq.getSize()<k)  //初始没取够
                pq.enqueue(new Freq(key,map.get(key)));
            else if (map.get(key)>pq.getFront().freq)  //取够了
            {
                pq.dequeue();
                pq.enqueue(new Freq(key,map.get(key)));
            }
        }

        int[] res = new  int[k];
        for (int i = 0 ; i < k ; i++)
        {
            res[i] = pq.dequeue().e;
        }
        return res;
    }
}