//https://leetcode.com/problems/swap-nodes-in-pairs/

import linkedList.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode headNext = head.next;
        head.next = swapPairs(headNext.next);
        headNext.next = head;

        return headNext;
    }
}
