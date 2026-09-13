Leetcode - 234
  Brute:
    class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int s = 0;
        int e = list.size() - 1;

        while (s < e) {
            if (list.get(s) != list.get(e)) return false;
            s++;
            e--;
        }

        return true;
    }
}

Better:
  class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode revHead = reverseList(head);

        while (head != null) {
            if (head.val != revHead.val) return false;

            head = head.next;
            revHead = revHead.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (head != null) {
            ListNode node = new ListNode(head.val);
            temp.next = node;
            temp = temp.next;
            head = head.next;
        }

        ListNode curr = dummy.next;
        ListNode prev = null;
        ListNode forw = null;

        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    }
}

Optimal:
  But a bit overcomplicated:
    class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;

        while (fast.next != slow) {
            fast = fast.next;
        }

        fast.next = null;
        slow = reverseList(slow);

        fast = head;

        while (slow != null && fast != null) {
            if (slow.val != fast.val) return false;

            slow = slow.next;
            fast = fast.next; 
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode forw = null;

        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    }
}
