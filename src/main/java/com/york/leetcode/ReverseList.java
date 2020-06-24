package com.york.leetcode;

/**
 * @author york
 * @create 2020-06-24 14:29
 **/
public class ReverseList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        printListNode(node);
        reverseList1(node);
        printListNode(node3);
    }

    private static void reverseList(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }
    // 递归解法
    private static ListNode reverseList1(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode p = reverseList1(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }

    private static void printListNode(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + "--->");
            cur = cur.next;
        }
        System.out.println();
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
}
