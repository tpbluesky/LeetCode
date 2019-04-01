package Problem92;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode q = h, p = head;
        int t = 1;
        while (t++ < m) {
            p = p.next;
            q = q.next;
        }
        ListNode g = new ListNode(-1);
        while (t++ <= n) {
            ListNode k = p.next;
            System.out.println(p.val);
            p.next = g;
            g = p;
            p = k;
        }
        q.next.next = p;
        q.next = g;
        return h.next;
    }
}