Leetcode - 229
  Brute : 
    class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int frq = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) frq++;
            }

            if (frq > n / 3) set.add(nums[i]);
        }

        return new ArrayList<>(set);
    }
}

Better : 
  class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for (int ele : map.keySet()) {
            if (map.get(ele) > n / 3) {
                list.add(ele);
            }
        }

        return list;
    }
}

Optimal : 
  class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = 0;
        int cnt1 = 0;
        int ele2 = 0;
        int cnt2 = 0;
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        
        for (int ele : nums) {
            if (cnt1 == 0 && ele2 != ele) {
                cnt1++;
                ele1 = ele;
            }else if (cnt2 == 0 && ele1 != ele) {
                cnt2++;
                ele2 = ele;
            }else if (ele == ele1) cnt1++;
            else if (ele == ele2) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        int frq1 = 0;
        int frq2 = 0;
        
        for (int ele : nums) {
            if (ele == ele1) frq1++;
            else if (ele == ele2) frq2++;
        }

        if (frq1 > n / 3) list.add(ele1);
        if (frq2 > n / 3) list.add(ele2);

        return list;
    }
}
