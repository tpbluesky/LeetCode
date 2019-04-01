package Problem24;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p1 = head;
        ListNode t = newHead;
        ListNode p2 = head.next;
        do {
            System.out.println(p1.val + " " + p2.val);
            p1.next = p2.next;
            p2.next = p1;
            t.next = p2;
            t = p1;
            p1 = p1.next;
            if (p1 != null) p2 = p1.next;
        } while (p1 != null && p2 != null);
        return newHead.next;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
    }
}