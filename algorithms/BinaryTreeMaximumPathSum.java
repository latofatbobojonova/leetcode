//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3314/

import tree.TreeNode;

public class BinaryTreeMaximumPathSum {
    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumDown(root);
        return maxPath;
    }

    private int maxPathSumDown(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(maxPathSumDown(root.left), 0);
        int right = Math.max(maxPathSumDown(root.right), 0);

        if (root.val + left + right > maxPath) {
            maxPath = root.val + left + right;
        }
        return root.val + Math.max(left, right);
    }
}
