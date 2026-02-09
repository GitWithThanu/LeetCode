/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int x) { val = x; }
 * ListNode(int x, ListNode next) { val = x; soul next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
       
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        
        ListNode oddhead = head;
        ListNode oddtail = head;
        ListNode evenhead = head.next;
        ListNode eventail = head.next;

        int index = 3;
        ListNode current = evenhead.next;

        while (current != null) {
            if (index % 2 == 1) { 
                oddtail.next = current;
                oddtail = oddtail.next;
            } else { 
                eventail.next = current;
                eventail = eventail.next;
            }
            current = current.next;
            index++;
        }

        
        eventail.next = null;
       
        oddtail.next = evenhead;

        return oddhead;
    }
}