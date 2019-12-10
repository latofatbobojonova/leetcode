//https://leetcode.com/problems/maximum-depth-of-binary-tree/
package easy.trees;

import tree.TreeNode;

public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);

        System.out.println(new MaxDepthBinaryTree().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
