Leetcode - 4
  Brute: 
    class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int i = 0;
        int j = 0;
        int k = 0;
        int[] merge = new int[n + m];

        while (i < n && j < m) {
            if (nums1[i] > nums2[j]) {
                merge[k++] = nums2[j++];
            } else {
                merge[k++] = nums1[i++];
            }
        }

        while (i < n) merge[k++] = nums1[i++];
        while (j < m) merge[k++] = nums2[j++];

        if ((n + m) % 2 == 0) {
            return (double) (merge[(n + m) / 2] + merge[((n + m) / 2) - 1]) / 2;
        }

        return merge[(n + m) / 2];
    }
}

Optimal: 
  
