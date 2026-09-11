GFG
  Optimal:
    class Solution {
    public Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        
        Node temp = head;
        
        while (temp != null) {
            Node store = temp.next;
            temp.next = temp.prev;
            temp.prev = store;
            
            if (temp.prev == null) break;
            temp = temp.prev;
        }
        
        return temp;
    }
}
