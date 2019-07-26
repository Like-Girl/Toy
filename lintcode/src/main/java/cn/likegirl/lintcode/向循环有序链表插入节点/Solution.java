package cn.likegirl.lintcode.向循环有序链表插入节点;

public class Solution {
    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public static ListNode insert(ListNode node, int x) {
        // write your code here
        ListNode newNode = new ListNode(x);
        if(node == null){
            newNode.next = newNode;
            return newNode;
        }
        ListNode first = node;
        ListNode tempNext;
        for (; ; ) {
            if (node.val == x || node.next == first) {
                swap(node, newNode);
                break;
            }
            tempNext = node.next == null ? first : node.next;
            if (node.val < tempNext.val) {
                if (x > node.val && x < tempNext.val) {
                    swap(node, newNode);
                    break;
                }
            }
            if (node.val > tempNext.val) {
                if (x > node.val) {
                    swap(node, newNode);
                    break;
                }
                if(x < tempNext.val){
                    swap(node, newNode);
                    break;
                }
            }
            node = node.next;
        }
        return node;
    }

    public static void swap(ListNode front, ListNode back) {
        back.next = front.next;
        front.next = back;
    }

    public static void read(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        read(head.next);
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(5);
//        ListNode node3 = new ListNode(1);
//
//        node2.next = node3;
//        node1.next = node2;

        read(insert(node1, 4));

    }
}