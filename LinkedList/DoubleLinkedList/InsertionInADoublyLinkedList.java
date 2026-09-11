GFG
  Optimal:
    class Solution {
    Node insertAtPos(Node head, int p, int x) {
        Node temp = head;
        
        while (p > 0) {
            temp = temp.next;
            p--;
        }
        
        Node storeNode = temp.next;
        Node newNode = new Node(x);
        
        temp.next = newNode;
        newNode.prev = temp;
        
        if (storeNode != null) {
            storeNode.prev = newNode;
            newNode.next = storeNode;
        }
        
        
        return head;
    }
}
