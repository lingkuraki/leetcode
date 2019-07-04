package com.kuraki.algorithms.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        List<Integer> list = new ArrayList<>();
        list = getInt(list, l1);
        list = getInt(list, l2);
        Collections.sort(list);
        ListNode listNode = new ListNode(list.get(0));
        ListNode curr = listNode;
        for (int i = 0; i < list.size() - 1; i++) {
            curr.val = list.get(i);
            curr.next = new ListNode(list.get(i + 1));
            curr = curr.next;
        }
        return listNode;
    }

    private List<Integer> getInt(List<Integer> list, ListNode listNode) {
        if (listNode != null) {
            ListNode current = listNode;
            list.add(listNode.val);
            while (current.next != null) {
                current = current.next;
                list.add(current.val);
            }
        }
        return list;
    }

    // 官方标准解答1
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    // 官方标准解答2
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);

        ListNode curr = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return listNode.next;
    }
}
