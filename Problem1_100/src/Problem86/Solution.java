package Problem86;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode(-1), g = new ListNode(-1);
        h.next = head;
        ListNode p = h, q = h.next, gh = g;
        while (q != null) {
            if (q.val < x) {
                p.next = q.next;
                g.next = q;
                q = q.next;
                g = g.next;
                g.next = null;
            }else {
                p = p.next;
                q = q.next;
            }
        }
        g.next = h.next;
        while(h != null){
            System.out.println(h.val);
            h = h.next;
        }
        return gh.next;
    }
}

