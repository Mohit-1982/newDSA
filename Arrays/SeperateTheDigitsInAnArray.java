Leetcode - 2553
  Optimal : 
    class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            digitsExtractor(nums[i], st);
        }

        int i = 0;
        int[] res = new int[st.size()];

        while (!st.isEmpty()) {
            res[i++] = st.pollFirst();
        }

        return res;
    }

    public void digitsExtractor(int num, ArrayDeque<Integer> st) {
        if (num == 0) {
            st.offerFirst(0);
            return;
        }
        while (num > 0) {
            st.offerFirst(num % 10);
            num /= 10;
        }
    }
}
