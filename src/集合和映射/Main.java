package 集合和映射;

import 链表.LinkedList;

import javax.sound.midi.Soundbank;

public class Main
{
    public static void main(String[] args) {
//        LinkListSet<Integer> linkListSet = new LinkListSet<>();
//        LinkedList<Integer> linkedList =   new LinkedList<>();
//        for (int i = 0; i < 10 ; i ++)
//        {
//            linkedList.addFirst(i);
//            linkListSet.add(i);
//        }
//        System.out.println(linkedList);
//        System.out.println(linkListSet);
//        for (int i = 5 ; i < 10 ; i ++)
//        {
//            linkedList.addFirst(i);
//            linkListSet.add(i);
//        }
//        System.out.println(linkedList);
//        System.out.println(linkListSet);
        LinkedListMap<Integer,Integer> map = new LinkedListMap();
        for (int i = 0 ; i < 10; i++)
        {
            if (map.contains(i))
                map.set(i,map.get(i)+1);
            else
                map.add(i,1);
        }
        for (int i = 5 ; i < 10; i++)
        {
            if (map.contains(i))
                map.set(i,map.get(i)+1);
            else
                map.add(i,1);
        }
        System.out.println(map);
    }

}
