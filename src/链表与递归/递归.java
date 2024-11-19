package 链表与递归;

import 链表.Main;

public class 递归 {
    public static int sum(int[] arr)
    {
        return sum(arr,0);
    }

    private static int sum(int[] arr ,int l)
    {
        if(l == arr.length)
            return 0;   //最基本问题
        return arr[l]+sum(arr,l+1);   //将原问题转换为跟小的问题
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,4,5};
        System.out.println(sum(a));
    }
}
