package easy;

import linkedList.ListNode;

public class MergeTwoSortedLists {
    public static void insertNode(ListNode head, int x) {
        ListNode newNode = new ListNode(x);
        newNode.next = head.next;
        head.next = newNode;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode outCursor = (l1.val < l2.val) ? l1 : l2;
        ListNode inCursor = (l1.val >= l2.val) ? l1 : l2;
        ListNode head = outCursor;

        while (inCursor != null && outCursor != null) {
            while (outCursor.next != null && inCursor.val >= outCursor.next.val) {
                outCursor = outCursor.next;
            }
            insertNode(outCursor, inCursor.val);
            inCursor = inCursor.next;
            outCursor = outCursor.next;
        }
        return head;
    }
}
