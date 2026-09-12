Leetcode - 206
  Brute:
    class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        List<ListNode> listStore = new ArrayList<>();

        while (temp != null) {
            listStore.add(temp);
            temp = temp.next;
        }

        ListNode prev = listStore.get(listStore.size() - 1);

        for (int i = listStore.size() - 2; i >= 0; i--) {
            ListNode curr = listStore.get(i);

            prev.next = curr;
            prev = curr;
        }

        prev.next = null;

        return listStore.get(listStore.size() - 1);
    }
}

Optimal:
  class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode forw = null;
        ListNode prev = null;

        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    }
}
