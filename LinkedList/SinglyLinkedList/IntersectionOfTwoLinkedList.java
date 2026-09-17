Leetcode - 160
  Optimal:
    public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;

        ListNode temp = headA;
        ListNode temp2 = headB;

        while (temp != null) {
            lenA++;
            temp = temp.next;
        }

        while (temp2 != null) {
            lenB++;
            temp2 = temp2.next;
        }

        ListNode move = (lenB > lenA) ? headB : headA;
        int diff = Math.abs(lenA - lenB);

        while (diff > 0) {
            move = move.next;
            diff--;
        }

        ListNode move2 = (lenB > lenA) ? headA : headB;

        while (move != null && move2 != null) {
            if (move == move2) return move;

            move = move.next;
            move2 = move2.next;
        }

        return null;
    }
}

Better:
  public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        ListNode t1 = headA;

        while (t1 != null) {
            set.add(t1);
            t1 = t1.next;
        }

        ListNode t2 = headB;

        while (t2 != null) {
            if (set.contains(t2)) return t2;
            t2 = t2.next;
        }

        return null;
    }
}
