//https://leetcode.com/problems/palindrome-linked-list/

import linkedList.ListNode;

/**
 * Solution using arrays is faster but consumes O(n) memory
 * Here is given O(n) time and O(1) memory solution
 */

public class PalindromeLinkedList {

    /**
     * First we find the length of LL
     * Then reverse the right middle
     * After, compare left and right middles between each other
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        int mid = len / 2;
        curr = head;
        for (int i = 0; i < mid; i++) {
            curr = curr.next;
        }
        ListNode rightHead = reverseList(curr);

        for (int i = 0; i < mid; i++) {
            if (head.val != rightHead.val) {
                return false;
            }

            head = head.next;
            rightHead = rightHead.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
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

}
