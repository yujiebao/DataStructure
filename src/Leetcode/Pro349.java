package Leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Pro349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num :nums1)
            set.add(num);

        ArrayList<Integer> list = new ArrayList();
           for(int num :nums2)
               if(set.contains(num))
               {
                   list.add(num);
                   set.remove(num);
               }

           int[] result = new int[list.size()];
               for(int i = 0 ; i < list.size(); i++)
               {
                   result[i] = list.get(i);
               }
           return result;
    }
}
