package 链表与递归;

public class Solution3 {
    public ListNode removeElements(ListNode head , int val)
    {
        if(head == null)
            return null;
//        ListNode  res = removeElements(head.next,val);
//        if(head.val == val)
//            return res;
//        else {
//            head.next = res;
//            return head;
//        }
        head.next = removeElements(head.next,val);
        return head.val==val?head.next:head;
    }
}
