//https://leetcode.com/problems/delete-node-in-a-linked-list/

import linkedList.ListNode;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        while (node.next.next != null) {
            node = node.next;
            node.val = node.next.val;
        }
        node.next = null;
    }
}
