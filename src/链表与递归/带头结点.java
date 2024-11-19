//package 链表与递归;
//
//import javax.sound.midi.Synthesizer;
//import java.nio.channels.Channels;
//
////  Definition for singly-linked list.
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
//
//class Solution {
//    //      public  void removeAllElements(ListNode head)
////      {
////
////      }
//    public static ListNode removeElements(ListNode head, int val) {
//         ListNode dummyHead = new ListNode(-1);
//         dummyHead.next = head;
//
//         ListNode prev = dummyHead ;
//         while (prev.next != null)
//         {
//             if(prev.next.val == val)
//                 prev.next = prev.next.next;
//             else
//                 prev = prev.next
//         }
//        return dummyHead.next;
//    }
//}
//public class 带头结点 {
//    public static void main(String[] args) {
//        ListNode a = new ListNode(1,null);
//        ListNode a1 = new ListNode(2,a);
//        ListNode a2 = new ListNode(2,a1);
//        ListNode a3 = new ListNode(3,a2);
//        ListNode a4 = new ListNode(2,a3);
//        ListNode head = a4;
//
//        head = Solution.removeElements(head,2);
//
//        System.out.println();
//        while(head != null)
//        {
//            System.out.println(head.val);
//            head = head.next;
//        }
//
//    }
//
//}
