Leetcode - 540
  Optimal But not clean: 
    class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            int left = -1;
            int right = -1;
            int eleIdx;

            if (m - 1 >= 0) left = nums[m - 1];
            if (m + 1 < n) right = nums[m + 1];

            if (left == nums[m]) {
                eleIdx = m - 1;

                if (eleIdx % 2 == 0 && m % 2 == 1) s = m + 1;
                else e = m - 1;
            } else if (right == nums[m]) {
                eleIdx = m + 1;

                if (eleIdx % 2 == 1 && m % 2 == 0) s = m + 1;
                else e = m - 1;
            } else {
                return nums[m];
            }

            // if (eleIdx % 2 == 0 && m % 2 == 1) {
            //     //even, odd pair
            //     s = m + 1;
            // } else {
            //     //odd, even pair
            //     e = m - 1;
            // }
        }

        return -1;
    }
}

Optimal and clean: 
  class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
        
            // if (m - 1 >= 0 && m + 1 < n && nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) return nums[m];
            if (m - 1 >= 0 && nums[m] == nums[m - 1]) {
                if ((m - 1) % 2 == 0 && m % 2 == 1) s = m + 1;
                else e = m - 1;
            } else if (m + 1 < n && nums[m] == nums[m + 1]) {
                if ((m + 1) % 2 == 0 && m % 2 == 1) e = m - 1;
                else s = m + 1;
            } else {
                return nums[m];
            }
        }

        return -1;
    }
}
