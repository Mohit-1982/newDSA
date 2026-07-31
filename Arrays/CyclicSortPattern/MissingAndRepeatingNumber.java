GFG
  Optimal: 
    class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int i = 0;
        int n = arr.length;
        
        while (i < n) {
            int idx = arr[i] - 1;
            
            if (arr[i] == i + 1 || arr[idx] == arr[i]) {
                i++;
                continue;
            }
            
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
        
        // for (int ele : arr) System.out.print(ele + " ");
        
        int miss = -1;
        int dup = -1;
        
        for (i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                miss = i + 1;
                dup = arr[i];
                break;
            }
        }
        
        return new ArrayList<>(List.of(dup, miss));
    }
}
