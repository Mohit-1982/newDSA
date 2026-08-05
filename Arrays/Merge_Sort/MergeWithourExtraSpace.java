GFG
  Optimal: 
    class Solution {
    public void mergeArrays(int a[], int b[]) {
        int i = a.length - 1;
        int j = 0;
        int m = b.length;
        
        while (i >= 0 && j < m) {
            if (a[i] > b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
    }
}


Optimal: 
  class Solution {
	public void mergeArrays(int a[], int b[]) {
		int n = a.length;
		int m = b.length;
		int len = n + m;
		int gap = (len / 2) + (len % 2);
		
		while (gap > 0) {
			int left = 0;
			int right = gap;
			
			while (right < len) {
				if (left < n && right >= n) {
					if (a[left] > b[right - n]) {
						int temp = a[left];
						a[left] = b[right - n];
						b[right - n] = temp;
					}
					
				} else if (left >= n) {
					if (b[left - n] > b[right - n]) {
						int temp = b[left - n];
						b[left - n] = b[right - n];
						b[right - n] = temp;
					}
					
				} else {
					if (a[left] > a[right]) {
						int temp = a[left];
						a[left] = a[right];
						a[right] = temp;
					}
					
				}
				
				left++;
				right++;
			}
			
			if (gap == 1)
				break;
			gap = (gap / 2) + (gap % 2);
		}
	}
}
