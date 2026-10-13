GFG
  Optimal:
    class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) q.add(i);
        }
        
        List<Integer> list = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while (j < n) {
            if (j - i + 1 < k) j++;
            else {
                while (!q.isEmpty() && q.peek() < i) {
                    q.remove();
                } 
                
                if (q.isEmpty()) {
                    list.add(0);
                    
                    i++;
                    j++;
                    continue;
                }
                
                int top = q.peek();
                
                if (top >= i && top <= j) {
                    list.add(arr[top]);
                } else {
                    list.add(0);
                }
                
                i++;
                j++;
            }
        }
        
        return list;
    }
}
