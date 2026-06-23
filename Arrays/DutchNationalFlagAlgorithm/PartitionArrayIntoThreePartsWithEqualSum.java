Leetcode - 1013
  Optimal : 
    class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        int total = 0;

        for (int ele : arr) total += ele;
        if (total % 3 != 0) return false;

        int target = total / 3;

        int sum = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == target) {
                sum = 0;
                count++;
            }
        }

        return count >= 3;
    }
}
