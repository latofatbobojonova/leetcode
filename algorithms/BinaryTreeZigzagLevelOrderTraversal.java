//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        count(root, 0);
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (i % 2 == 1) {
                list.set(i, reverseList(list.get(i)));
            }
        }
        return list;
    }

    public List<Integer> reverseList(List<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(len - i - 1));
            list.set(len - i - 1, temp);
        }

        return list;
    }

    public void count(TreeNode node, int level) {
        if (node == null)
            return;

        if (level > list.size() - 1) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(node.val);

        count(node.left, level + 1);
        count(node.right, level + 1);
    }
}
