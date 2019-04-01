package Problem2;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        int pre = 0;
        ListNode tmp = ans;
        while (l1 != null || l2 != null || pre != 0) {
            int res = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + pre;
            tmp.next = new ListNode(res % 10);
            pre = res / 10;
            tmp = tmp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return ans.next;
    }
}