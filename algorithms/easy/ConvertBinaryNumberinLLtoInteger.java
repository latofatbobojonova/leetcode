//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
package easy;

import linkedList.ListNode;

public class ConvertBinaryNumberinLLtoInteger {
    public int getDecimalValue(ListNode head) {
        int dec = 0;
        while (head != null) {
            dec *= 2;
            dec += head.val;
            head = head.next;
        }
        return dec;
    }
}
