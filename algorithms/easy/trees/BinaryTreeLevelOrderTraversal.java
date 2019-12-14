//https://leetcode.com/problems/binary-tree-level-order-traversal/
package easy.trees;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        count(root, 0);
        return lists;
    }

    public void count(TreeNode root, int level) {
        if (root == null)
            return;

        if (lists.size() < level + 1) {
            lists.add(new ArrayList<>());
        }

        lists.get(level).add(root.val);

        count(root.left, level + 1);
        count(root.right, level + 1);
    }
}
