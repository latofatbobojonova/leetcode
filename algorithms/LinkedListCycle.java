//https://leetcode.com/problems/linked-list-cycle/

import linkedList.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && slow != null) {
            slow = slow.next;

            if (fast.next == null) {
                break;
            }

            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
