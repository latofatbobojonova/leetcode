//https://leetcode.com/problems/symmetric-tree/

import tree.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isTwoNodesSymmetric(root.left, root.right);
    }

    public boolean isTwoNodesSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;

        return node1.val == node2.val &&
                isTwoNodesSymmetric(node1.left, node2.right) && isTwoNodesSymmetric(node1.right, node2.left);
    }
}
