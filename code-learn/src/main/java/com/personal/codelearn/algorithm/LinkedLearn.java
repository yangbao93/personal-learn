package com.personal.codelearn.algorithm;


import com.personal.codelearn.algorithm.entity.LinkedNode;

/**
 * 链表操作
 */
public class LinkedLearn {

    public static LinkedNode<Integer> createLinked1() {
        LinkedNode<Integer> end = new LinkedNode<Integer>(3, null);
        LinkedNode<Integer> next2 = new LinkedNode<Integer>(2, end);
        LinkedNode<Integer> next1 = new LinkedNode<Integer>(1, next2);
        LinkedNode<Integer> head = new LinkedNode<Integer>(0, next1);
        return head;
    }

    public static LinkedNode<Integer> createLinked2() {
        LinkedNode<Integer> end = new LinkedNode<Integer>(6, null);
        LinkedNode<Integer> next2 = new LinkedNode<Integer>(5, end);
        LinkedNode<Integer> next1 = new LinkedNode<Integer>(4, next2);
        LinkedNode<Integer> head = new LinkedNode<Integer>(3, next1);
        return head;
    }


    /**
     * 链表的反转
     * @param head 传入的参数
     * @return 新的链表
     */
    public static LinkedNode reverseList(LinkedNode head) {
        if (head == null) {
            return null;
        }
        if (head.next() == null) {
            return head;
        }
        LinkedNode newHead = reverseList(head.next());
        head.next().linkNext(head);
        head.linkNext(null);
        return newHead;
    }

    /**
     * 链表的合并
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后的链表
     */
    public static LinkedNode mergeList(LinkedNode l1, LinkedNode l2) {
        // 边界问题处理
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        LinkedNode head = new LinkedNode(0, null);
        LinkedNode next = head;
        while (l1 != null && l2 != null) {
            int l1Val = (int) l1.value();
            int l2Val = (int) l2.value();
            if (l1Val <= l2Val) {
                next.linkNext(l1);
                l1 = l1.next();
            } else {
                next.linkNext(l2);
                l2 = l2.next();
            }
            next = next.next();
        }
        if (l1 != null) {
            next.linkNext(l1);
        } else {
            next.linkNext(l2);
        }
        return head.next();
    }

    /**
     * 链表的拆分
     * @param head 链表
     */
    public static void splitLinked(LinkedNode head) {
        if (head == null) {
            return;
        }
        LinkedNode head1 = head;
        LinkedNode head2 = head.next();
        LinkedNode h2 = head2;
        while (head1 != null && head2 != null) {
            head1.linkNext(head2.next());
            head1 = head1.next();
            if (head1 != null) {
                head2.linkNext(head1.next());
            }
            head2 = head2.next();
        }
        printLinked(head);
        printLinked(h2);
    }

    public static void printLinked(LinkedNode linkedNode) {
        StringBuffer sb = new StringBuffer();
        while (linkedNode != null) {
            sb.append(linkedNode.value()).append(",");
            linkedNode = linkedNode.next();
        }
        if (sb.length() != 0) {
            sb.substring(0, sb.length() - 1);
        }
        System.out.println(sb.toString());
    }



    public static void main(String[] args) {
        LinkedNode<Integer> node = createLinked1();
        LinkedNode<Integer> node2 = createLinked2();
        LinkedNode reverseList = reverseList(node);
        printLinked(reverseList);
//        LinkedNode mergeList = mergeList(node, node2);
//        printLinked(mergeList);
//        LinkedNode<Integer> node3 = createLinked1();
//        splitLinked(node3);
    }


}
