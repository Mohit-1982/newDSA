GFG
  Optimal:
    class Solution {
	public int minTime(int[] arr, int k) {
		return splitArray(arr, k);
	}
	
	public int splitArray(int[] nums, int k) {
		int n = nums.length;
		
		if (k > n)
			return - 1;
		
		long s = max(nums);
		long e = sum(nums);
		long res = Long.MAX_VALUE;
		
		while (s <= e) {
			long m = s + (e - s) / 2;
			long larSum = isPossible(nums, k, m);
			
			if (larSum != -1) {
				res = Math.min(res, larSum);
				e = m - 1;
			} else {
				s = m + 1;
			}
		}
		
		return (int) res;
	}
	
	public long isPossible(int[] arr, int arraysToCreate, long capacity) {
		long lar = Long.MIN_VALUE;
		int currSubArrays = 1;
		long currCapacity = 0;
		
		for (int ele : arr) {
			if (ele + currCapacity > capacity) {
				currCapacity = ele;
				currSubArrays++;
				
				if (currSubArrays > arraysToCreate)
					return - 1;
			} else {
				currCapacity += ele;
			}
			
			lar = Math.max(lar, currCapacity);
		}
		
		return lar;
	}
	
	public long sum(int[] arr) {
		long sum = 0;
		
		for (int ele : arr)
			sum += ele;
		
		return sum;
	}
	
	public int max(int[] arr) {
		int max = 0;
		
		for (int ele : arr)
			max = Math.max(max, ele);
		
		return max;
	}
}
