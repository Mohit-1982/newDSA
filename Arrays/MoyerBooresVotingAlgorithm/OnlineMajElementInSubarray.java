Leetcode - 1157
  Brute : 
    class MajorityChecker {
    int[] nums;

    public MajorityChecker(int[] arr) {
        nums = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }    
    }
    
    public int query(int left, int right, int threshold) {
        int maj = -1;
        int count = 0;

        for (int i = left; i <= right; i++) {
            if (count == 0) {
                maj = nums[i];
            }

            if (nums[i] == maj) count++;
            else count--;
        }

        int frq = 0;

        for (int i = left; i <= right; i++) {
            if (nums[i] == maj) frq++;
        }

        return (frq >= threshold) ? maj : -1;
    }
}
