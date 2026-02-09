/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        //find middle element
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        //Reverse 2nd half
        ListNode current=slow;
        ListNode prev=null;
        ListNode next=null;

        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        ListNode first=head;
        ListNode second=prev;
        while(second.next!=null)
        {
            ListNode firstNext=first.next;
            ListNode secondNext=second.next;

            first.next=second;
            second.next=firstNext;

            first=firstNext;
            second=secondNext;
        }
    }
}