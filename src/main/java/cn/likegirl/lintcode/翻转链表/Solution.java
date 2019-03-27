package cn.likegirl.lintcode.翻转链表;


import java.util.Collections;
import java.util.concurrent.ConcurrentMap;

/**
 * 35. 翻转链表
 * 中文English
 * 翻转一个链表
 *
 * 样例
 * 样例1:
 * 对于链表 1->2->3, 翻转链表为 3->2->1
 * 样例2:
 * 对于链表 1->2->3->4, 翻转链表为 4->3->2->1
 *
 * 挑战
 * 在原地一次翻转完成
 */
public class Solution {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public static ListNode reverse(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = reverse(head.next);
        ListNode next = head.next;
        head.next = null;
        next.next = head;
        return node;
    }

    public static void read(ListNode head){
        if(head == null){
            return;
        }
        System.out.println(head.val);
        read(head.next);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        node1.next = node2;
        ListNode reverse = reverse(node1);
        read(reverse);
    }


}


