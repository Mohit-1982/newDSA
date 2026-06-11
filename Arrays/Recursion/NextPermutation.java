Leetcode - 31
  Brute : 
    class Solution {
    public void nextPermutation(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> permu = new ArrayList<>();

        genPermu(nums, list, permu, set);
        permu.sort((a, b) -> {
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }
            return 0;
        });

        for (int i = 0; i < permu.size(); i++) {
            if (isEqual(permu.get(i), nums)) {
                if (i < permu.size() - 1) {
                    makeNums(permu.get(i + 1), nums);
                } else {
                    makeNums(permu.get(0), nums);
                }
                break;
            }
        }
    }

    public void makeNums(List<Integer> list, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    public boolean isEqual(List<Integer> list, int[] arr) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != arr[i]) return false;
        }

        return true;
    }

    public void genPermu(int[] arr, List<Integer> list, List<List<Integer>> perm, HashSet<Integer> set) {
        if (set.size() == arr.length) {
            perm.add(new ArrayList<>(list));
            return;
        } 

        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(i)) {
                list.add(arr[i]);
                set.add(i);
                genPermu(arr, list, perm, set);
                list.remove(list.size() - 1);
                set.remove(i);
            }
        }
    }
}

Optimal : 
  class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        reverse(nums, idx + 1, n - 1);
    }

    public void reverse(int[] arr, int s, int e) {

        while (s < e) {
            int temp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = temp; 
        }
    }
}
