package Problem142;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        int flagInt = Integer.MIN_VALUE / 2;
        while (head.next != null) {
            head.val = flagInt;
            head = head.next;
            if (head.val == flagInt) {
                return head;
            }
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        int cnt = 1;
        fast = slow.next;
        while (slow != fast) {
            fast = fast.next;
            cnt++;
        }
        fast = head;
        slow = head;
        while (cnt-- > 0) {
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
