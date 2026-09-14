Leetcode - 148
  Better:
    class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        head = sort(head);

        return head;
    }

    public ListNode sort(ListNode head) {
        int i = 0;
        int len = calcLen(head);

        if (len == 1) return head;

        ListNode t1 = head;

        while (i < ((len / 2) - 1)) {
            i++;
            t1 = t1.next;
        }

        ListNode t2 = t1.next;
        t1.next = null;

        t1 = sort(head);//don't write t1 here because t1 is at the last node of its list
        t2 = sort(t2);
        return mergeSort(t1, t2);
    }

    public int calcLen(ListNode head) {
        int i = 0;

        while (head != null) {
            i++;
            head = head.next;
        }

        return i;
    }

    public ListNode mergeSort(ListNode t1, ListNode t2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (t1 != null && t2 != null) {
            if (t1.val > t2.val) {
                temp.next = t2;
                t2 = t2.next;
            } else {
                temp.next = t1;
                t1 = t1.next;
            }

            temp = temp.next;
        }

        while (t1 != null) {
            temp.next = t1;
            t1 = t1.next;
            temp = temp.next;
        }

        while (t2 != null) {
            temp.next = t2;
            t2 = t2.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}

Optimal:
  class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        head = sort(head);

        return head;
    }

    public ListNode sort(ListNode head) {
        if (head.next == null) return head;

        ListNode t1 = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            t1 = t1.next;
            fast = fast.next.next;
        }

        ListNode t2 = t1.next;
        t1.next = null;

        t1 = sort(head);//don't write t1 here because t1 is at the last node of its list
        t2 = sort(t2);
        return mergeSort(t1, t2);
    }

    public ListNode mergeSort(ListNode t1, ListNode t2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (t1 != null && t2 != null) {
            if (t1.val > t2.val) {
                temp.next = t2;
                t2 = t2.next;
            } else {
                temp.next = t1;
                t1 = t1.next;
            }

            temp = temp.next;
        }

        while (t1 != null) {
            temp.next = t1;
            t1 = t1.next;
            temp = temp.next;
        }

        while (t2 != null) {
            temp.next = t2;
            t2 = t2.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
