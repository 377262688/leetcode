package com.york.leetcode;

/**
 * @author york
 * @create 2020-11-25 17:34
 **/
public class BinaryTree {

    private int getBinaryTreeDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = getBinaryTreeDepth(node.left);
            int rightDepth = getBinaryTreeDepth(node.right);
            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }

    static class BinaryTreeNode {
        private Object value;

        private BinaryTreeNode left;

        private BinaryTreeNode right;

        public BinaryTreeNode(Object value, BinaryTreeNode left, BinaryTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
