package Leetcode;

public class Main {
    public static void main(String[] args) {
//        String[] a = {"gin","zen","gig","msg"};
//        System.out.println(Pro804.uniqueMorseRepresentations(a));
        int[] num = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        Pro347 pro347 =new Pro347();
        int[] res = pro347.topKFrequent(num,1);
        for (int i : res)
            System.out.println(i);
    }
}
