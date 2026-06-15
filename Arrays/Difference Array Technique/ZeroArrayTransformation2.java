Leetcode - 3356
  Brute : 
    class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int k = 0;
        int n = nums.length;
        if (wholeZero(nums)) return 0;

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int v = queries[i][2];

            for (int j = l; j <= r; j++) {
                nums[j] -= v;
                if (nums[j] < 0) nums[j] = 0;
            } 

            if (wholeZero(nums)) return i + 1;
        }

        return -1;
    }

    public boolean wholeZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) 
                return false;
        }

        return true;
    }
}

Optimal : 
  
