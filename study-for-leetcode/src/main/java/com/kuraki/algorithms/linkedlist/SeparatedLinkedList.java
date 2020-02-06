package com.kuraki.algorithms.linkedlist;

import com.kuraki.algorithms.common.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * @author 凌波
 */
public class SeparatedLinkedList {

    public ListNode partition(ListNode head, int x) {
        // 创建一个哑结点
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        // 令最后一个节点指向不为null，防止循环的出现
        after.next = null;
        // 去除哑结点
        before.next = afterHead.next;
        // 去除哑结点
        return beforeHead.next;
    }
}
