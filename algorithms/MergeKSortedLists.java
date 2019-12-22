//https://leetcode.com/problems/merge-k-sorted-lists/

import linkedList.ListNode;

import java.util.Arrays;

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;

        if (len == 0) {
            return null;
        }

        if (len == 1) {
            return lists[0];
        }

        if (len == 2) {
            return mergeTwoSortedLists(lists[0], lists[1]);
        }

        return mergeTwoSortedLists(
                mergeKLists(Arrays.copyOfRange(lists, 0, (len + 1) / 2)),
                mergeKLists(Arrays.copyOfRange(lists, (len + 1) / 2, len)));
    }

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {

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

    public static void insertNode(ListNode head, int x) {
        ListNode newNode = new ListNode(x);
        newNode.next = head.next;
        head.next = newNode;
    }

    public static void printLinkedList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print(head.val);
        System.out.println();
    }
}
