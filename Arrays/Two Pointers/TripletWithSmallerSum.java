GFG
  Optimal : 
    class Solution {
    int countTriplets(int sum, int arr[]) {
        int count = 0;
        Arrays.sort(arr);
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            
            int j = i + 1;
            int k = n - 1;
            
            while (j < k) {
                int sumTrip = arr[i] + arr[j] + arr[k];
                
                if (sumTrip < sum) {
                    count += k - j;
                    j++;
                     while (j < k && arr[j] == arr[j - 1]) j++;
                }else {
                    k--;
                    while (k > j && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        
        return count;
    }
}
