//https://leetcode.com/problems/validate-binary-search-tree/

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        listInorder(root);
        int len = list.size();

        if (len < 2)
            return true;

        for (int i = 1; i < len; i++) {
            if (list.get(i - 1) >= list.get(i))
                return false;
        }

        return true;
    }

    public void listInorder(TreeNode root) {
        if (root == null)
            return;

        listInorder(root.left);
        list.add(root.val);
        listInorder(root.right);
    }
}
