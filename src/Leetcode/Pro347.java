package Leetcode;

import 队列.PriorityQueue;

import java.util.TreeMap;

public class Pro347 {

    public class Freq implements Comparable<Freq>{
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
