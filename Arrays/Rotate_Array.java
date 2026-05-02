Leetcode - 189
  Brute :
    class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        int n = nums.length;
        k %= n;

        for (int i = 0; i < k; i++) {
            for (int j = n - 1; j > 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }
}

Better :
  class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) return;

        Queue<Integer> q = new LinkedList<>();
        int loopTill = n - k;

        for (int i = 0; i < n; i++) {
            q.add(nums[i]);
        }

        for (int i = 0; i < loopTill; i++) {
            q.add(q.remove());
        }

        int i = 0;
        while (!q.isEmpty()) {
            nums[i++] = q.remove();
        }
    }
}

Optimal : 
  class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) return;

        rev(0, n - k - 1, nums);
        rev(n - k, n - 1, nums);
        rev(0, n - 1, nums);
    }

    public void rev(int i, int j, int[] nums) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
