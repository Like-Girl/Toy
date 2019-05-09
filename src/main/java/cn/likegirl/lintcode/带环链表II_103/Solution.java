package cn.likegirl.lintcode.带环链表II_103;

/**
 * 103. 带环链表 II
 * 中文English
 * 给定一个链表，如果链表中存在环，则返回到链表中环的起始节点，如果没有环，返回null。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入：null,no cycle
 * 输出：no cycle
 * 解释：
 * 链表为空，所以没有环存在。
 * 样例 2:
 * <p>
 * 输入：-21->10->4->5，tail connects to node index 1
 * 输出：10
 * 解释：
 * 最后一个节点5指向下标为1的节点，也就是10，所以环的入口为10。
 * 挑战
 * 不使用额外的空间
 * <p>
 * <p>
 * 解题思路：
 * 使用双指针判断链表中是否有环，慢指针每次走一步，快指针每次走两步，若链表中有环，则两指针必定相遇。
 * 假设环的长度为l，环上入口距离链表头距离为a，两指针第一次相遇处距离环入口为b，则另一段环的长度为c=l-b，
 * 由于快指针走过的距离是慢指针的两倍，则有a+l+b=2*(a+b),又有l=b+c，可得a=c，故当判断有环时(slow==fast)时，
 * 移动头指针，同时移动慢指针，两指针相遇处即为环的入口。
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        ListNode fast = head,
                slow = head;
        for (; ; ) {
            if (fast == null || fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        for (; ; ) {
            if (head == slow) {
                return head;
            }
            head = head.next;
            slow = slow.next;
        }
    }
}




