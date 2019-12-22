//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
package easy.trees;

import tree.TreeNode;

public class ConvertSortedArrayToBST {
    private int[] sortedArray;

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        sortedArray = nums;

        return assignValToBST(0, len - 1);
    }

    public TreeNode assignValToBST(int lo, int hi) {
        if (lo > hi)
            return null;

        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(sortedArray[mid]);

        node.left = assignValToBST(lo, mid - 1);
        node.right = assignValToBST(mid + 1, hi);

        return node;
    }
}
