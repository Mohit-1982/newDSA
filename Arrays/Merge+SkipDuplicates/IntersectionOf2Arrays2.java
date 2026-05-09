Leetcode - 350
  Optimal : 
    class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for (int ele : nums1) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for (int ele : nums2) {
            map1.put(ele, map1.getOrDefault(ele, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (int ele : map.keySet()) {
            if (map1.containsKey(ele)) {
                int minFreq = Math.min(map.get(ele), map1.get(ele));

                for (int i = 0; i < minFreq; i++) {
                    res.add(ele);
                }
            }
        }

        int i = 0;
        int[] arr = new int[res.size()];

        for (int ele : res) {
            arr[i++] = ele;
        }

        return arr;
    }
}

More Optimal : 
    class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n > m) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for (int ele : nums1) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }


        List<Integer> res = new ArrayList<>();

        for (int ele : nums2) {
            if (map.containsKey(ele)) {
                if (map.get(ele) > 0) {
                    res.add(ele);
                    map.put(ele, map.get(ele) - 1);
                }
            }
        }

        int i = 0;
        int[] arr = new int[res.size()];

        for (int ele : res) {
            arr[i++] = ele;
        }

        return arr;
    }
}
