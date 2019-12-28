//https://leetcode.com/problems/linked-list-cycle-ii/

import linkedList.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && slow != null) {
            slow = slow.next;

            if (fast.next == null) {
                break;
            }

            fast = fast.next.next;

            // There is a cycle
            if (slow == fast) {
                int k = findCycleLength(fast);
                return findCycleHead(head, k);
            }
        }

        return null;
    }

    private int findCycleLength(ListNode node) {
        ListNode cur = node;
        int k = 0;

        do {
            k++;
            cur = cur.next;
        } while (cur != node);

        return k;
    }

    private ListNode findCycleHead(ListNode head, int cycleLen) {
        ListNode p1 = head;
        ListNode pk = head;

        while (cycleLen-- > 0) {
            pk = pk.next;
        }

        while (p1 != pk) {
            p1 = p1.next;
            pk = pk.next;
        }

        return p1;
    }
}
