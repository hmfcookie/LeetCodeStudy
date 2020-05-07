package com.mfcookie.sort;

public class LeetCode147 {
    public static void main(String[] args) {
        Solution147.ListNode node1 = new Solution147.ListNode(4);
        Solution147.ListNode node2 = new Solution147.ListNode(2);
        Solution147.ListNode node3 = new Solution147.ListNode(1);
        Solution147.ListNode node4 = new Solution147.ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution147 solution147 = new Solution147();
        Solution147.ListNode node = solution147.insertionSortList(node1);
        while (node != null) {
            Solution147.ListNode current = node;
            System.out.print(current.val);
            node = current.next;
        }
    }
}

/**
 * 147. 对链表进行插入排序
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = head;
        ListNode current = head.next;

        dummy.next = head;

        while (current != null) {
            if (current.val >= pre.val) {
                pre = current;
                current = current.next;
            } else {
                ListNode p = dummy;
                while (p.next.val < current.val) {
                    p = p.next;
                }

                // 把pre指针指向current节点的next
                pre.next = current.next;

                // 将current插到p和p.next之间
                ListNode next = p.next;
                current.next = next;
                p.next = current;

                current = pre.next;
            }

        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

