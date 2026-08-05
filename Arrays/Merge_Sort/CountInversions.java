GFG
  Optimal: 
    class Solution {
	public int inversionCount(int arr[]) {
		int n = arr.length;
		int[] res = new int[1];
		
		mergeSort(arr, res);
		return res[0];
	}
	
	public void mergeSort(int[] arr, int[] res) {
	    int n = arr.length;
	    
	    if (n <= 1) return;
	    
	    int k = 0;
	    int[] a = new int[n - n / 2];
	    int[] b = new int[n / 2];
	    
	    for (int i = 0; i < a.length; i++) {
	        a[i] = arr[k++];
	    }
	    
	    for (int i = 0; i < b.length; i++) {
	        b[i] = arr[k++];
	    }
	    
	    mergeSort(a, res);
	    mergeSort(b, res);
	    res[0] += merge(a, b, arr);
	}
	
	public int merge(int[] a, int[] b, int[] arr) {
	    int i = 0;
	    int j = 0;
	    int k = 0;
	    int count = 0;
	    int n = a.length;
	    int m = b.length;
	    
	    while (i < n && j < m) {
	        if (a[i] > b[j]) {
	            count += n - i;
	            arr[k++] = b[j++];
	        } else {
	            arr[k++] = a[i++];
	        }
	    }
	    
	    while (i < n) arr[k++] = a[i++];
	    while (j < m) arr[k++] = b[j++];
	    
	    return count;
	}
}


//Brute Force --> O(n2)
// int count = 0;
// int n = arr.length;

// for (int i = 0; i < n; i++) {
// 	for (int j = i + 1; j < n; j++) {
// 		if (arr[i] > arr[j])
// 			count++;
// 	}
// }

// return count;
