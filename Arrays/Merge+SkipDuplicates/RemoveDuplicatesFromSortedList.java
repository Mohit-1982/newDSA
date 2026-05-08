Leetcode - 83
Better : 
  class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode dummy = new ListNode(-101);
        ListNode t = dummy;

        while (temp != null) {
            if (t.val != temp.val) {
                ListNode n = new ListNode(temp.val);
                t.next = n;
                t = t.next;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}

Optimal : 
  class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode temp = head;
        // ListNode dummy = new ListNode(-101); No need of dummy node
        ListNode t = head;

        while (temp != null) {
            if (t.val != temp.val) {
                t.next = temp;
                t = t.next;
            }
            temp = temp.next;
        }

        t.next = null;
        return head;
    }
}
