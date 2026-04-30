Leetcode - 1752
  Opitmal : 
    class Solution {
    public boolean check(int[] nums) {
        int k = -1;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                k = i;
                break;
            }
        }

        if (k == -1) return true;

        reverse(nums, 0, k);
        reverse(nums, k + 1, n - 1);

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public void reverse(int[] arr, int i, int j) {

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

Optimal : 
  class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }

        if (nums[0] < nums[n - 1]) {
            count++;
        }

        return count <= 1;
    }
}
