Leetcode - 349
Brute : 
  class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        HashSet<Integer> set = new HashSet<>();

        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i++]);
                j++;
            }else if (nums1[i] > nums2[j]){
                j++;
            }else {
                i++;
            }
        }

        i = 0;
        int[] arr = new int[set.size()];

        for (int ele : set) {
            arr[i++] = ele;
        }

        return arr;
    }
}

Optimal : 
  class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < m; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        
        int i = 0;
        int[] arr = new int[set2.size()];

        for (int ele : set2) {
            arr[i++] = ele;
        }

        return arr;
    }
}
  
