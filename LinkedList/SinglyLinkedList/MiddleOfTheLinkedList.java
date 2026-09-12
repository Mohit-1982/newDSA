Leetcode - 876
  Better:
    class Solution {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        int i = 0;
        temp = head;

        while (i < (len / 2)) {
            i++;
            temp = temp.next;
        }

        return temp;
    }
}

Optimal:
  class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode t = head;
        ListNode h = head;

        while (h != null && h.next != null) {
            h = h.next.next;
            t = t.next;
        }

        return t;
    }
}
