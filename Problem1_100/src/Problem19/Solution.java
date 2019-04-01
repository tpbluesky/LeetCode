package Problem19;

import java.util.Scanner;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (n-- > 0 && p2 != null) p2 = p2.next;
        if (p2 == null) return head.next;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next == null?null: p1.next.next;
        return head;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
    }
}