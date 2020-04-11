//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3293/


import tree.TreeNode;

public class DiameterOfBT {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        computeDepth(root);

        return max - 1;
    }

    public int computeDepth(TreeNode root) {
        if (root == null) return 0;

        int l = computeDepth(root.left);
        int r = computeDepth(root.right);

        max = Math.max(max, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
