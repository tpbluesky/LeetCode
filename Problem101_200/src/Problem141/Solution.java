package Problem141;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        int flagInt = Integer.MIN_VALUE / 2;
        while (head.next != null) {
            head.val = flagInt;
            head = head.next;
            if (head.val == flagInt) {
                return true;
            }
        }
        return false;
    }
}