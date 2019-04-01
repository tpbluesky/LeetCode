package Problem82;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode p = h, q = h.next;
        while (q != null) {
            ListNode t = q.next;
            while (t != null && t.val == q.val) {
                t = t.next;
                q = q.next;
            }
            if (p.next != q) {
                p.next = t;
                q = t;
            } else {
                p = q;
                q = q.next;
            }
        }
        return h.next;
    }
}