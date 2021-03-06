package com.personal.codelearn.leetcode.leetcode.editor.cn;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 891 👎 0

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
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1, head);
        rev(head, node);
        return node.next;
    }

    private void rev(ListNode head, ListNode parent) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        parent.next = next;
        rev(head.next, head);
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
    //    so.swapPairs(l1);
    //    System.out.println("end");
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
