package com.york.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author york
 * @create 2020-11-25 17:34
 **/
public class BinaryTree {

    private int getBinaryTreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = getBinaryTreeDepth(node.left);
            int rightDepth = getBinaryTreeDepth(node.right);
            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();


        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        if (preorder.length != inorder.length) {
            throw new IllegalArgumentException();
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return root;
        }

        return root;
    }

    public static void isTwoMi(int n) {
        System.out.println((n - 1) & n);
    }

    public static void numberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag > 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        isTwoMi(8);
        numberOf1(-15);
    }

    static class TreeNode {
        private Integer val;

        private TreeNode left;

        private TreeNode right;
    }
}
