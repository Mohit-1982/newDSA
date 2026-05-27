Leetcode - 169
  Brute : 
    class Solution {
    public int majorityElement(int[] nums) {
        int mostFreq = -1;
        int mostFreqEle = -1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int freq = 0;
            for (int j = i; j < n; j++) {
                if (nums[i] == nums[j]) freq++;
            }

            if (freq > mostFreq) {
                mostFreq = freq;
                mostFreqEle = nums[i];
            }
        } 

        return (mostFreq > n / 2) ? mostFreqEle : -1;  
    }
}

Better : 
  class Solution {
    public int majorityElement(int[] nums) {
        int freq = -1;
        int n = nums.length;
        int mostFreqEle = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);

            if (map.get(ele) > freq) {
                freq = map.get(ele);
                mostFreqEle = ele;
            }
        }

        return (freq > n / 2) ? mostFreqEle : -1;
    }
}

Optimal : 
  class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = -1;
        int n = nums.length;
        
        for (int element : nums) {
            // if (count == 0) {
            //     ele = element;
            //     count++;
            // }else if (ele == element) {
            //     count++;
            // }else {
            //     count--;
            // }

            if (count == 0) ele = element;
            count += (ele == element) ? 1 : -1;
        }

        int freq = 0;

        for (int element : nums) {
            if (ele == element) {
                freq++;
            }
        }

        return (freq > n / 2) ? ele : -1;
    }
}
