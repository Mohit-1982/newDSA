Leetcode - 23
  Brute:
    class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        int idx = 0;
        ListNode head = null;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                idx = i;
                head = lists[i];
                break;
            }
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for (int i = idx + 1; i < lists.length; i++) {

            ListNode temp = head;
            ListNode prev = null;
            ListNode t = lists[i];
            
            while (t != null) {
                pq.add(t);
                t = t.next;
            }

            while (temp != null) {

                while (!pq.isEmpty() && temp.val > pq.peek().val) {
                    ListNode pop = pq.remove();
                    pop.next = null;

                    if (prev != null) {
                        prev.next = pop;
                    }

                    if (prev == null) head = pop;

                    pop.next = temp;
                    prev = pop;
                }

                prev = temp;
                temp = temp.next;
            }

            while (!pq.isEmpty()) {
                ListNode pop = pq.remove();
                pop.next = null;

                prev.next = pop;
                prev = prev.next;
            }
        }

        return head;
    }
}

  
  Better: TC --> O(NK)
    class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = null;

        for (ListNode node : lists) {
            if (node == null) continue;

            temp = mergeTwoLists(temp, node);
        }

        return temp;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            }else {
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            }
        }

        if (temp1 == null) temp.next = temp2;
        if (temp2 == null) temp.next = temp1;

        return dummy.next;
    }
}

Optimal:
  class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for (ListNode node : lists) {
            if (node == null) continue;

            pq.add(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            ListNode pop = pq.remove();
            if (pop.next != null) pq.add(pop.next);
            
            pop.next = null;
            temp.next = pop;
            
            temp = temp.next;
        }

        return dummy.next;
    }
}
