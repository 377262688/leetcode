package com.york.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author york
 * @create 2020-06-28 10:48
 **/
public class HasCycle {


    public static boolean hasCycle(ListNode head) {
        Object o = new Object();
        Map<ListNode,Object> map = new HashMap<>();
        ListNode node = head;
        while (node != null) {
            if (map.get(node) != null) {
                return true;
            }
            map.put(node,o);
            node = node.next;
        }

        //
        ListNode node1 = head;
        ListNode node2 = head;
        while (node1 != null && node2 != null) {
            if (node2.next == null) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) {
                return true;
            }
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
}
