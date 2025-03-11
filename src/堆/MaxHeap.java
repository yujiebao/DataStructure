package 堆;

import 数组.Array;
import 数组.GenericArray;

import java.util.regex.Pattern;


//堆为一棵完全二叉树--->只有最后一层的左边有
public class MaxHeap<E extends Comparable<E>> {
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

//      1
//  2       3
//4   5    6   7
//
//      0
//  1       2
//3  4     5  6

