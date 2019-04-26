package Problem147;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 新建一个头节点，使原链表带有头节点，方便统一处理
 * 每次插入一个值从有序的链表的头开始查找插入的位置
 */
class Solution {
    public ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode vh = new ListNode(-1);
        vh.next = head;
        ListNode h = head, p = head.next;
        head.next = null;
        while (p != null) {
            ListNode q = vh, t = p.next;
            while (q.next != null && p.val > q.next.val) q = q.next;
            p.next = q.next;
            q.next = p;
            p = t;
        }
        return vh.next;
    }

    /**
     * 归并排序的写法
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        System.out.println();
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode h1 = insertionSortList(head);
        ListNode h2 = insertionSortList(second);
        ListNode h_new = new ListNode(0);
        ListNode h = h_new;
        while (h1 != null && h2 != null) {
            if (h1.val > h2.val) {
                h.next = h2;
                h2 = h2.next;
            } else {
                h.next = h1;
                h1 = h1.next;
            }
            h = h.next;
        }
        if (h1 != null) h.next = h1;
        if (h2 != null) h.next = h2;
        return h_new.next;
    }
}