GFG
  Optimal:
    class Solution {
    public int lengthOfLoop(Node head) {
        return detectCycle(head);
    }
    
    public int detectCycle(Node head) {
            Node slow = head;
            Node fast = head;
            boolean cycleExists = false;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    cycleExists = true;
                    break;
                }
            }

            if (!cycleExists) return 0;

            int len = 1;
            slow = slow.next;

            while (slow != fast) {
                len++;
                slow = slow.next;
            } 
            
            return len;
        }
}
