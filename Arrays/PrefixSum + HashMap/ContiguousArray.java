Leetcode - 525

  Brute : 
    class Solution {
    public int findMaxLength(int[] nums) {
        int len = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int one = 0;
            int zero = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == 1) one++;
                else zero++;

                if (one == zero) len = Math.max(j - i + 1, len);
            }
        }

        return len;
    }
}

Optimal : 
  class Solution {
    public int findMaxLength(int[] nums) {
        int len = 0;
        int sum = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < n; i++) {
            sum += (nums[i] == 0) ? -1 : 1;

            // if (sum == 0) {
            //     len = i + 1;
            // }else {
            //     if (map.containsKey(sum)) {
            //         len = Math.max(len, i - map.get(sum));
            //     }
            // }
            if (map.containsKey(sum))
                len = Math.max(len, i - map.get(sum));

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return len;
    }
}
