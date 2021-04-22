package com.personal.codelearn.leetcode.leetcode.editor.cn;
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1697 👎 0

// 2021-04-22 15:38:18
//leetcode submit region begin(Prohibit modification and deletion)

import com.personal.codelearn.leetcode.entity.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode rev = rev(head, next);
        return rev;
    }

    public ListNode rev(ListNode head, ListNode next) {
        if (next == null) {
            return head;
        }
        ListNode next1 = next.next;
        next.next = head;
        return rev(next, next1);
    }

    //public static void main(String[] args) {
    //    ListNode l1 = new ListNode(1);
    //    ListNode l2 = new ListNode(2);
    //    ListNode l3 = new ListNode(3);
    //    ListNode l4 = new ListNode(4);
    //    l1.setNext(l2);
    //    l2.setNext(l3);
    //    l3.setNext(l4);
    //    Solution so = new Solution();
    //    so.reverseList(l1);
    //    System.out.println("end");
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
