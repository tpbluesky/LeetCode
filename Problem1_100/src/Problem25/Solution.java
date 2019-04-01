package Problem25;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode prev = head;
        int cnt = 1;
        while (head.next != null && cnt < k) {
            head = head.next;
            cnt++;
        }
        if (cnt < k) return prev;
        ListNode t = prev;
        ListNode tt = prev;
        ListNode nextHead = head.next;
        prev = prev.next;
        while (prev != nextHead) {
            ListNode tmp = prev.next;
            prev.next = t;
            t = prev;
            prev = tmp;
        }
        ListNode newHead = reverseKGroup(nextHead, k);
        tt.next = newHead;
        return t;
    }


    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
    }
}