GFG
  Optimal:
    class Solution {
	public int findPages(int[] arr, int k) {
		int n = arr.length;
		
		if (k > n) return -1;
		
		int res = Integer.MAX_VALUE;
		long s = calcMax(arr);
		long e = calcSum(arr);
		
		while (s <= e) {
			long m = s + (e - s) / 2;
			int maxPageAllocated = isPossible(arr, k, m);
			
			if (maxPageAllocated != -1) {
				e = m - 1;
				res = Math.min(res, maxPageAllocated);
			} else {
				s = m + 1;
			}
		}
		
		return (res != Integer.MAX_VALUE) ? res : -1;
	}
	
	public int isPossible(int[] arr, int students, long maxPagesCanAllocate) {
		int student = 1;
		int pageAllocated = 0;
		int maxPageAllocated = 0;
		
		for (int ele : arr) {
			if (pageAllocated + ele > maxPagesCanAllocate) {
				student++;
				pageAllocated = ele;
				
				if (student > students)
					return - 1;
			} else
			pageAllocated += ele;
			
			maxPageAllocated = Math.max(maxPageAllocated, pageAllocated);
		}
		
		return maxPageAllocated;
	}
	
	public long calcMax(int[] arr) {
	    int max = 0;
	    
	    for (int ele : arr) max = Math.max(ele, max);
	    
	    return max;
	}
	
	public long calcSum(int[] arr) {
		long sum = 0;
		
		for (int ele : arr)
			sum += ele;
		return sum;
	}
}
