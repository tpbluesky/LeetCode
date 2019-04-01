package Problem61;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = 0;
        for (ListNode p = head; p != null; p = p.next) len++;
        k %= len;
        if (k == 0) return head;
        ListNode p = head, q = head;
        for (; k > 0; k--) p = p.next;
        for (; p.next != null; p = p.next, q = q.next) ;
        ListNode ans = q.next;
        p.next = head;
        q.next = null;
        return ans;
    }
}
