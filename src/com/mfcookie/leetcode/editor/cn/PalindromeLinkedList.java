package com.mfcookie.leetcode.editor.cn;

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 708 👎 0


public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        boolean listNode = solution.isPalindrome(node1);
        System.out.println("listNode = " + listNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            ListNode half = half(head);
            ListNode nextHalfRe = reverseList(half.next);

            ListNode p1 = head;
            ListNode p2 = nextHalfRe;
            while (p1 != null && p2 != null) {
                if (p1.val != p2.val) {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            reverseList(half.next);
            return true;
        }

        public ListNode half(ListNode head) {
            ListNode low = head, high = head;
            while (high.next != null && high.next.next != null) {
                low = low.next;
                high = high.next.next;
            }
            return low;
        }

        public ListNode reverseList(ListNode node) {
            ListNode pre = null, curr = node;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = nextTemp;
            }
            return pre;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}