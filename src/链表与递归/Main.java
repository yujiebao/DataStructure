//package 链表与递归;
//
//import javax.sound.midi.Synthesizer;
//import java.nio.channels.Channels;
//
////  Definition for singly-linked list.
////  class ListNode {
////      int val;
////      ListNode next;
////      ListNode() {}
////      ListNode(int val) { this.val = val; }
////      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
////  }
//
//class Solution {
////      public  void removeAllElements(ListNode head)
////      {
////
////      }
//    public static ListNode removeElements(ListNode head, int val) {
////        ListNode delNode = head;
////        while(delNode !=null&&delNode.val == val)
//        while(head !=null&& head.val == val)
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
//          else  //移动指针写在else中，删除元素时不移动指针再次判断避免漏了连续情况
//            prv = prv.next;
//        }
//        return head;
//    }
//}
//public class Main {
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
