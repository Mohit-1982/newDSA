Leetcode - 1539
  Brute: 
    class Solution {
    public int findKthPositive(int[] arr, int k) {
        //TC --> O(max ele in arr)
        //SC --> O(max ele in arr)

        int[] store = new int[arr[arr.length - 1] + 1];

        for (int ele : arr) {
            store[ele]++;
        }

        int count = 0;
        for (int i = 1; i < store.length; i++) {
            if (store[i] == 0) {
                count++;

                if (count == k) return i;
            }
        }

        return arr[arr.length - 1] + (k - count);
        //k - count because if one number is missing inside the range than we have to find the k - 1 missing number because this one is in the range now we will check for k - 1 here
    }
}

Optimal : 
  
