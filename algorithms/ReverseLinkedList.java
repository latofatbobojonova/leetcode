//https://leetcode.com/problems/reverse-linked-list/

import linkedList.ListNode;

public class ReverseLinkedList {

    public ListNode reverseListIteratively(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;

        while (cur.next != null) {
            ListNode curNext = cur.next;
            cur.next = curNext.next;
            curNext.next = head;
            head = curNext;
        }

        return head;
    }

    public ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversedListHead = reverseListIteratively(head.next);
        ListNode current = reversedListHead;

        while (current.next != null) {
            current = current.next;
        }

        current.next = head;
        head.next = null;
        head = reversedListHead;

        return head;
    }
}
