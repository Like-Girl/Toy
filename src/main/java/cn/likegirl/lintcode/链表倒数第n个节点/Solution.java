package cn.likegirl.lintcode.链表倒数第n个节点;


/**
 * 166. 链表倒数第n个节点
 * 中文English
 * 找到单链表倒数第n个节点，保证链表中节点的最少数量为n。
 *
 * 样例
 * Example 1:
 * 	Input: list = 3->2->1->5->null, n = 2
 * 	Output: 1
 *
 *
 * Example 2:
 * 	Input: list  = 1->2->3->null, n = 3
 * 	Output: 1
 */
public class Solution {
    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list. 
     */
    public static ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode node = head;
        for(;;){
            if(head == null){
                return node;
            }
            head = head.next;
            if(--n < 0){
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(5);

        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        System.out.println(nthToLast(node1,2).val);

    }
}

