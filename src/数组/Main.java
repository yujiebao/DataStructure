package 数组;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

//        一般的数组使用
          /**int[] arr = new int[10];
          for (int i= 0;i<arr.length;i++)
          {
              arr[i] = i;
          }
          for(int i :arr)
          {
              System.out.println(i);
          }*/

          //int型的自定义数组
          /** Array array = new Array(10);
           for(int i = 0 ; i< 5;i++)
           {
           array.addLast(i);
           }
           //        array.show();
           //        System.out.println();
           System.out.println(array);
           //        array.add(2,1000);
           //        array.set(1,80);
           //        array.remove(3);
           array.delete(2);
           System.out.println(array);
           * */
          //泛型自定义数组
        GenericArray<Integer> array = new GenericArray<>(5);
        for(int i = 0 ; i< 5;i++)
        {
            array.addLast(i);
        }
//        array.show();
//        System.out.println();
        System.out.println(array);
//        array.add(2,1000);
//        array.set(1,80);
        array.remove(3);
//        array.addLast(2);
        System.out.println(array);

    }
}
