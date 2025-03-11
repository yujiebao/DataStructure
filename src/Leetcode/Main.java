package Leetcode;

import 链表.LinkedList;

import java.util.List;

public class Main {
    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }
    public static void main(String[] args) {
//        String[] a = {"gin","zen","gig","msg"};
//        System.out.println(Pro804.uniqueMorseRepresentations(a));
        int[] num = {4,1,-1,2,-1,2,3};
        Pro347 pro347 =new Pro347();
//        int[] res = pro347.topKFrequent(num,2);
        printList((new Pro347()).topKFrequent(num, 2));

    }
}
