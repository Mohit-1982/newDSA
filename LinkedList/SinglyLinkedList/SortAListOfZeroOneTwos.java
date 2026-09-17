GFG
  Optimal:
    class Solution {
    public Node segregate(Node head) {
        Node zero = new Node(-1);
        Node t1 = zero;
        
        Node one = new Node(-1);
        Node t2 = one;
        
        Node two = new Node(-1);
        Node t3 = two;
        
        Node temp = head;
        
        while (temp != null) {
            if (temp.data == 0) {
                t1.next = temp;
                t1 = t1.next;
                temp = temp.next;
                t1.next = null;
            } else if (temp.data == 1) {
                t2.next = temp;
                t2 = t2.next;
                temp = temp.next;
                t2.next = null;
            } else {
                t3.next = temp;
                t3 = t3.next;
                temp = temp.next;
                t3.next = null;
            }
        }
        
        if (one.next != null) t1.next = one.next;
        else t1.next = two.next;
        t2.next = two.next;
        
        if (zero.next != null) return zero.next;
        else if (one.next != null) return one.next;
        return two.next;
    }
}

Optimal:
  class Solution {
    public Node segregate(Node head) {
        int zero = 0;
        int one = 0;
        int two = 0;
        
        Node temp = head;
        
        while (temp != null) {
            if (temp.data == 0) zero++;
            if (temp.data == 1) one++;
            if (temp.data == 2) two++;
            
            temp = temp.next;
        }
        
        temp = head;
        
        while (zero > 0) {
            temp.data = 0;
            zero--;
            temp = temp.next;
        }
        
        while (one > 0) {
            temp.data = 1;
            one--;
            temp = temp.next;
        }
        
        while (two > 0) {
            temp.data = 2;
            two--;
            temp = temp.next;
        }
        
        return head;
    }
}
