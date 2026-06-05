Leetcode - 844
  Better : 
    class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        int m = t.length();
        Deque<Character> st = new LinkedList<>();
        Deque<Character> tt = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '#' && !st.isEmpty()) {
                st.pop();
            } else if (ch != '#') {
                st.push(ch);
            }
        }

        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);

            if (ch == '#' && !tt.isEmpty()) {
                tt.pop();
            } else if (ch != '#') {
                tt.push(ch);
            }
        }

        if (st.size() != tt.size()) return false;

        while (!st.isEmpty()) {
            if (st.pop() != tt.pop()) return false;
        }
        
        return true;
    }
}

Optimal :   
  
