Brute : 
  class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean odd = false;
            boolean even = false;

            if (nums[i] % 2 == 0) even = true;
            else odd = true;
            
            for (int j = i + 1; j < n; j++) {
                if (even && nums[j] % 2 == 1) {//even & odd case
                    count++;
                }
                if (odd && nums[j] % 2 == 0) {//odd & even case
                    count++;
                }
            }

            res[i] = count;
        }

        return res;
    }
}©leetcode
    still brute : 
      class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                even.add(i);
            }else {
                odd.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {//even & odd check case
                for (int j = 0; j < odd.size(); j++) {
                    if (odd.get(j) > i) {
                        res[i] = odd.size() - j;
                        break;
                    }
                }
            }else {//odd & even check case
                for (int j = 0; j < even.size(); j++) {
                    if (even.get(j) > i) {
                        res[i] = even.size() - j;
                        break;
                    }
                }
            }
        }

        return res;
    }
}©leetcode
