package Problem83;

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
        ListNode p = head, q = head.next;
        while (q != null) {
            while (q != null && p.val == q.val) q = q.next;
            p.next = q;
            p = q;
        }
        return head;
    }
}