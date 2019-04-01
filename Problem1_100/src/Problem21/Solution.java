package Problem21;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            p.next = l1.val > l2.val ? l2 : l1;
            if (l1.val > l2.val) l2 = l2.next;
            else l1 = l1.next;
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return head.next;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
    }
}