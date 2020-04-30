//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/

import tree.TreeNode;

public class CheckValidSequenceInBinaryTree {
    private int[] string;
    private int searchDepth;
    private boolean isValidExist;

    public boolean isValidSequence(TreeNode root, int[] arr) {
        string = arr;
        searchDepth = arr.length - 1;

        checkNode(root, 0);

        return isValidExist;
    }

    private void checkNode(TreeNode node, int level) {
        if (node == null || level > searchDepth) return;

        if (level == searchDepth && isLeaf(node) && node.val == string[level])
            isValidExist = true;


        if (node.val == string[level]) {
            checkNode(node.left, level + 1);
            checkNode(node.right, level + 1);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.right == null && node.left == null;
    }
}
