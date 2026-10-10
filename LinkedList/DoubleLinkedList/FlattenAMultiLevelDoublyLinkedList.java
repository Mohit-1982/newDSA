Leetcode - 430
  Optimal: 
class Solution {
    public Node flatten(Node head) {
        helper(head);

        return head;
    }

    public Node helper(Node head) {
        if (head == null) return null;

        Node temp = head;
        Node tail = head;

        while (temp != null) {
            if (temp.child != null) {
                Node store = temp.next;

                Node flatten = helper(temp.child);

                temp.next = temp.child;
                temp.child.prev = temp;

                temp.child = null;

                if (store != null) {
                    flatten.next = store;
                    store.prev = flatten;
                }
                
                temp = flatten;
            }

            tail = temp;
            temp = temp.next;
        }

        return tail;
    }
}
