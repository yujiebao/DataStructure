package 堆;
//
//import java.util.Random;
//import java.util.zip.CheckedOutputStream;
//
//public class Main {
//    public static void main(String[] args) {
//        int n = 10000000;
////        MaxHeap<Integer> maxHeap = new MaxHeap<>();
////        Random random = new Random();
//
////        for (int i = 0 ; i < n ;i ++ )
////            maxHeap.add();
//
////        int[] arr = new int[n];
//
////        for (int i = 0 ; i < n ; i++ )
////            arr[i] = maxHeap.extractMax();
//
//        Random random = new Random();
//        Integer[] arr1 = new Integer[n];
//        for (int i = 0 ; i < n ; i++ )
//            arr1[i] = random.nextInt(Integer.MAX_VALUE);
//
//
//        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr1);
//
//        int[] arr = new int[n];
//        for (int i = 0 ; i < n ; i++ )
//            arr[i] = maxHeap.extractMax();
//        for (int i = 1 ;i < n ; i++)
//            if (arr[i-1] < arr[i] )
//                throw new IllegalArgumentException("ERROR");
//
//        for (int i = 0 ;i < n ; i++)
//            System.out.println(arr[i]);
//        System.out.println("Succes");
//    }
//}

import java.util.Random;

public class Main {

    private static double testHeap(Integer[] testData, boolean isHeapify){

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>();
            for(int num: testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for(int i = 0 ; i < testData.length ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < testData.length ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}
