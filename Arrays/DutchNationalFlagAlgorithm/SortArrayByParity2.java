Leetcode - 922
  Better : 
    class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;

        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                while (i < n && nums[i] % 2 != 0) {
                    i++;
                }

                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                i++;
            }else {
                while (j < n && nums[j] % 2 == 0) {
                    j++;
                }

                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                j++;
            }
        }

        return nums;
    }
}

Optimal : 
  class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int e = 0;
        int o = 1;
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                res[e] = nums[i];
                e += 2;
            }else {
                res[o] = nums[i];
                o += 2;
            }
        }

        return res;
    }
}
