package Problem148;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode t_small = small, t_large = large;
        int t = head.val;
        ListNode p = head.next;
        while (p != null) {
            if (p.val < t) {
                small.next = p;
                small = small.next;
            } else {
                large.next = p;
                large = large.next;
            }
            p = p.next;
        }
        small.next = large.next = null;
        ListNode part1 = sortList(t_small.next);
        ListNode part2 = sortList(t_large.next);
        ListNode q = part1;
        while (q != null && q.next != null) {
            q = q.next;
        }
        if (q != null)
            q.next = head;
        head.next = part2;
        return part1 == null ? head : part1;
    }
}