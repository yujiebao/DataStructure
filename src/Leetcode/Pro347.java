package Leetcode;

//import 队列.PriorityQueue;
import com.sun.source.tree.CompilationUnitTree;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import  java.util.Comparator;
public class Pro347 {

//    public class Freq implements Comparable<Freq>{
//        public int e, freq;
//
//        public Freq(int e , int freq)
//        {
//            this.e = e;
//            this.freq = freq;
//        }
//        @Override
//        public int compareTo(Freq freq) {
//            return freq.e - e;
//        }
//    }

//    public int[] topKFrequent(int[] nums, int k) {
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for (int num : nums) {
//            if (map.containsKey(num))
//                map.put(num, map.get(num) + 1);
//            else
//                map.put(num, 1);
//        }
//        PriorityQueue<Freq> pq = new PriorityQueue<>();
//        for(int key : map.keySet())
//        {
//            if (pq.getSize()<k)  //初始没取够
//                pq.enqueue(new Freq(key,map.get(key)));
//            else if (map.get(key)>pq.getFront().freq)  //取够了
//            {
//                pq.dequeue();
//                pq.enqueue(new Freq(key,map.get(key)));
//            }
//        }
//
//        int[] res = new  int[k];
//        for (int i = 0 ; i < k ; i++)
//        {
//            res[i] = pq.dequeue().e;
//        }
//        return res;
//    }
        public class Freq implements Comparable<Freq>
        {
            public int e, freq;

            public Freq(int e , int freq)
            {
                this.e = e;
                this.freq = freq;
            }



            @Override
            public int compareTo(Freq freq) {
                return  freq.e - e;     //java自带的优先队列使用的是最小堆，所以此处比较逻辑反过来
            }
//        @Override
//        public int compareTo(Freq another){
//                if(this.freq < another.freq)
//                    return -1;
//                else if(this.freq > another.freq)
//                    return 1;
//                else
//                    return 0;
//            }
        }
//public class Freq
//{
//    public int e, freq;
//
//    public Freq(int e , int freq)
//    {
//        this.e = e;
//        this.freq = freq;
//    }
//
//
//
//    //            @Override
////            public int compareTo(Freq freq) {
////                return  this.e- freq.e;     //java自带的优先队列使用的是最小堆，所以此处比较逻辑反过来
////            }
//}
//
//        private class FreqComparator implements Comparator<Freq>
//        {
//            @Override
//            public int compare(Freq a , Freq b)
//            {
//                return a.freq-b.freq;
//            }
//        }


    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.peek().freq){
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove().e);
        return res;


        }
}
