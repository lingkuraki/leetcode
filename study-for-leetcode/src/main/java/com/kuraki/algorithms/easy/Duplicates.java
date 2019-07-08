package com.kuraki.algorithms.easy;

import java.util.TreeSet;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class Duplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(head.val);
        ListNode l = head;
        while (l.next != null) {
            l = l.next;
            treeSet.add(l.val);
        }
        ListNode l1 = new ListNode(treeSet.first());
        l = l1;
        treeSet.remove(head.val);
        for (Integer integer : treeSet) {
            l.next = new ListNode(integer);
            l = l.next;
        }
        return l1;
    }

    // 官方解答，注意：是已经排序好了的链表
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
