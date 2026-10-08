Leetcode - 25
  Optimal:
    class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0 || k == 1) return head;

        int count = 1;
        ListNode temp = head;
        ListNode point = head;

        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;


        while (temp != null) {
            count++;
            temp = temp.next;

            if (temp == null) break;

            if (count % k == 0) {
                ListNode makeNull = temp;
                if (temp != null) temp = temp.next;
                if (makeNull != null) makeNull.next = null;

                t.next = reverse(point);
                t = point;
                point = temp;

                // while (t.next != null) t = t.next; no need just point t to point variable
                count++;
            }
        }

        if (point != null) t.next = point;

        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode c = head;
        ListNode p = null;
        ListNode f = null;

        while (c != null) {
            f = c.next;
            c.next = p;
            p = c;
            c = f;
        }

        return p;
    }
}
