//https://leetcode.com/problems/maximum-depth-of-binary-tree/
package top_interview_easy.trees;

import tree.TreeNode;

public class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
