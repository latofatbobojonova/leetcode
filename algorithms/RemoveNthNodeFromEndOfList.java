import linkedList.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthNodeFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (n-- > 0) {
            p2 = p2.next;
        }

        if (p2 != null) {

            while (p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }

            p1.next = p1.next.next;
        } else {  // When p1 is head;
            head = head.next;
        }

        return head;
    }
}
