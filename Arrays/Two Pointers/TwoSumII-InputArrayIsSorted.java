Leetcode - 167
  Optimal : 
    class Solution {
    public int[] twoSum(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] + arr[j] < target) {
                i++;
            }else if (arr[i] + arr[j] > target) {
                j--;
            }else {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[]{-1, -1};
    }
}
