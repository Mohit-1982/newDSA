Leetcode - 2540
  Better : 
    class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return getCommon(nums2, nums1);
        }

        HashSet<Integer> set = new HashSet<>();

        for (int ele : nums1) {
            set.add(ele);
        }

        for (int ele : nums2) {
            if (set.contains(ele)) {
                return ele;
            }
        }

        return -1;
    }
}

Optimal : 
  class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0; 
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;

        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }else if (nums1[i] > nums2[j]) {
                j++;
            }else {
                i++;
            }
        }

        return -1;
    }
}
