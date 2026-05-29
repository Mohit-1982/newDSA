Leetcode - 1186
  Optimal : 
    class Solution {
    public int maximumSum(int[] arr) {
        int res = arr[0];
        int noDel = arr[0];
        int oneDel = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int ele = arr[i];
            int prevNoDel = noDel;
            int prevOneDel = oneDel;
            
            int v1;
            if (prevOneDel == Integer.MIN_VALUE) {
                v1 = ele;
            }else {
                v1 = prevOneDel + ele;
            }

            noDel = Math.max(prevNoDel + ele, ele);
            oneDel = Math.max(v1, prevNoDel); 
            res = Math.max(res, Math.max(noDel, oneDel));
        }

        return res;
    }
}
