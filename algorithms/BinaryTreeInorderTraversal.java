//https://leetcode.com/problems/binary-tree-inorder-traversal/

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    //    Using recursion
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        inorderTraversalRecursion(root.left);
        list.add(root.val);
        inorderTraversalRecursion(root.right);

        return list;
    }

//    Using Stack and iteration

    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;
    }

//    Using Morris Traversal

    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                list.add(current.val);
                current = current.right;
            } else {
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                rightmost.right = current;
                current = current.left;
                rightmost.right.left = null;
            }
        }

        return list;
    }
}
