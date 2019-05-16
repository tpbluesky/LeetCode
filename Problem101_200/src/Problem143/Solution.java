package Problem143;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 先通过快慢指针找到中点，然后将其分成两个链表，倒转后面一个链表(遍历过程中使用头插法)，再进行合并
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nHead = reverse(slow.next);
        slow.next = null;
        ListNode h1 = head, h2 = nHead;
        while (h2 != null) {
            ListNode t1 = h1.next, t2 = h2.next;
            h1.next = h2;
            h2.next = t1;
            h1 = t1;
            h2 = t2;
        }
    }

    /**
     * 使用头插法反转一个链表
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nHead = head, q = head.next;
        nHead.next = null;
        while (q != null) {
            ListNode t = q.next;
            q.next = nHead;
            nHead = q;
            q = t;
        }
        return nHead;
    }
}