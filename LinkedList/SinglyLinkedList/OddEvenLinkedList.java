Leetcode - 328
  Optimal:
    class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head;
        
        ListNode d1 = new ListNode(-1);
        ListNode t1 = d1;

        ListNode d2 = new ListNode(-1);
        ListNode t2 = d2;

        while (temp != null) {
            t1.next = temp;
            t1 = t1.next;
            temp = temp.next;

            t2.next = temp;
            t2 = t2.next;
            if (temp != null) temp = temp.next;
        }

        t1.next = d2.next;

        return d1.next;
    }
}
