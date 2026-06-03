Leetcode - 977
  Brute : 
    class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }
}

Better :
  class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = -1;
        int j = 0;
        int k = 0;
        int n = nums.length;
        int[] res = new int[n]; 

        for (int l = 0; l < n - 1; l++) {
            if (nums[l + 1] >= 0) {
                i = l;
                break;
            }
        }

        for (int l = 0; l < n; l++) {
            nums[l] = nums[l] * nums[l];
        }
        
        if (i == -1) {//all negatives
            i = n - 1;  
            j = n;
        } else j = i + 1;

        while (i >= 0 && j < n) {
            if (nums[i] > nums[j]) res[k++] = nums[j++];
            else res[k++] = nums[i--];
        }

        while (i >= 0) res[k++] = nums[i--];
        while (j < n) res[k++] = nums[j++];

        return res;
    }
}

Optimal : 
  class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[r + 1];

        for (int i = r; i >= 0; i--) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[i] = nums[l] * nums[l];
                l++;
            }else {
                res[i] = nums[r] * nums[r];
                r--;
            }
        }

        return res;
    }
}
  
