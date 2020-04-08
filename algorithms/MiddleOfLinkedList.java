//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3290/


import linkedList.ListNode;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {

        if (head == null) return null;

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2.next != null) {
            p1 = p1.next;

            if (p2.next.next != null)
                p2 = p2.next.next;
            else
                p2 = p2.next;
        }

        return p1;
    }
}