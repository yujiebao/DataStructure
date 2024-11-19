//package 链表与递归;
//
//import javax.sound.midi.Synthesizer;
//
////  Definition for singly-linked list.
//  class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
//
//class Solution {
////      public  void removeAllElements(ListNode head)
////      {
////
////      }
//    public static ListNode removeElements(ListNode head, int val) {
////        ListNode delNode = head;
////        while(delNode !=null&&delNode.val == val)
//        while(head !=null && head.val == val)
//        {
//            head = head.next;
////            head = delNode.next;
////            delNode.next = null;
//        }
//        if(head == null)
//        {
//            return null;
//        }
//
//        ListNode prv = head;
//        while(prv.next != null)
//        {
//            if (prv.next.val ==val)
//            {
//                prv.next = prv.next.next;
//            }
//            else
//            {
//                prv = prv.next;
//            }
//        }
//        return head;
//    }
//}
//public class A {
//    public static void main(String[] args) {
//        ListNode a = new ListNode(1,null);
//        ListNode a1 = new ListNode(2,a);
//        ListNode a2 = new ListNode(2,a1);
//        ListNode a3 = new ListNode(3,a2);
//        ListNode a4 = new ListNode(2,a3);
////        ListNode head = a4;
////        while(head != null)
////        {
////            System.out.println(head.val);
////            head = head.next;
////        }
//
//        ListNode head = a4;
//
//        head = Solution.removeElements(head,2);
//
//
//        while(head != null)
//        {
//            System.out.println(head.val);
//            head = head.next;
//        }
//
//    }
//
//}
