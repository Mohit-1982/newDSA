GFG
  Optimal:
    class Solution {
    public Node deleteHead(Node head) {
        if (head == null || head.next == null) return null;
        
        Node headNext = head.next;
        
        head.next = null;
        headNext.prev = null;
        
        return headNext;
    }
}
