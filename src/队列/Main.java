package 队列;

import 数组.Array;

import java.util.Random;

public class Main {
    /*
    * 测试
    * */
    private static double testQueue(Queue<Integer> q, int opCount)
    {
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0 ;i < opCount;i++)
        {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0;i < opCount; i++)
        {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {
//        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
//        queue.enqueue(3);
//        for(int i = 0; i < 5; i++)
//        {
//            queue.enqueue(i);
//        }
//        System.out.println(queue);
//        int[] a = new int[3];
//        a[0] = queue.dequeue();
//        a[1] = queue.dequeue();
//        a[2] = queue.dequeue();
//        for(int i = 0 ; i < 3; i++)
//            System.out.println(a[i]);
//        System.out.println(queue);
        int opCount = 100000;
        Arrayqueue<Integer> arrayqueue = new Arrayqueue<>();
        double time = testQueue(arrayqueue,opCount);
        System.out.println("ArrayQueue, time: "+time+"S");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        time = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue, time: "+time+"S");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        time = testQueue(linkedListQueue,opCount);
        System.out.println("LinkedListQueue, time: "+time+"S");

    }
}
