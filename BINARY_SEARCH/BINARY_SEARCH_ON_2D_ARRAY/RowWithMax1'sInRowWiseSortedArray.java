GFG
  Optimal: 
    class Solution {
    public int rowWithMax1s(int[][] arr) {
        int rowNum = -1;
        int noOfOne = -1;
        
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            int k = arr[i].length - 1;
            
            while (j <= k) {
                int m = j + (k - j) / 2;
                
                if (arr[i][m] == 1) k = m - 1;
                else j = m + 1;
            }
            
            if (j >= arr[i].length) continue;
            
            if (noOfOne < (arr[i].length - j)) {
                noOfOne = arr[i].length - j;
                rowNum = i;
            }
        }
        
        return rowNum;
    }
}
