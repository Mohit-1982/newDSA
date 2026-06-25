GFG
  Optimal : 
    class Solution {
    public int findCeil(int[] arr, int x) {
        int s = 0;
        int e = arr.length - 1;
        
        while (s <= e) {
            int m = s + (e - s) / 2;
            
            if (arr[m] < x) s = m + 1;
            else e = m - 1;
        }
        
        return (s >= arr.length) ? -1 : s;
    }
}
