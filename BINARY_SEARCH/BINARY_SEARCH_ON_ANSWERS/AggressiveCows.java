GFG
  Optimal: 
    class Solution {
	public int aggressiveCows(int[] arr, int k) {
	    Arrays.sort(arr); // we have to sort first becasue 
	    //if we have something like x, y and we place the cow here 
	    //then if x + 1, z then we can place the cow here 
	    //then distance between x and x + 1 cow can be lesser than our gap this will give wrong answer
	    
		int max = 0;
		for (int ele : arr)
			max = Math.max(max, ele);
		
		int n = arr.length;
		if (k > n)
			return -1;
		
		int s = 0;
// 		int e = (int) Math.ceil((double) max / k); this won't work 
        // int e = max;
        int e = arr[n - 1] - arr[0];
		int res = -1;
		
		while (s <= e) {
			int m = s + (e - s) / 2; // gap between two cows
			int dist = isPossible(arr, k, m);
			
			if (dist != -1) {
				s = m + 1; // try to maximize the gap
				res = Math.max(res, dist);
			} else {
				e = m - 1;
			}
		}
		
		return res;
	}
	
	public int isPossible(int[] arr, int k, int gap) {
		int cow = 1;
		int cowPos = arr[0];
		int minDist = Integer.MAX_VALUE;
		
		for (int i = 1; i < arr.length; i++) {
			int cowGap = arr[i] - cowPos;
			
			if (cowGap >= gap) {
				// we can place the cow in this stall
				minDist = Math.min(cowGap, minDist);
				cow++;
				cowPos = arr[i];
				
				if (cow >= k)
					return minDist;
			}
		}
		
		return - 1;
	}
}
