Leetcode - 61
  Optimal:
    class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;

        int len = 0;
        ListNode tail = new ListNode(-1);
        ListNode temp = head;

        while (temp != null) {
            len++;
            tail = temp;
            temp = temp.next;
        }

        k %= len;

        if (k == 0) return head;
        temp = head;
        
        int count = 0;

        while (count != len - k - 1) {
            count++;
            temp = temp.next;
        }

        ListNode point =temp.next;
        temp.next = null;
        tail.next = head;

        return point;
    }
}
