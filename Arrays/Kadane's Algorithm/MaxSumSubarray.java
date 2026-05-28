GFG
  class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        int start = -1;
        int ansS = -1;
        int ansE = -1;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                while (i < arr.length - 1 && arr[i + 1] < 0) {
                    i++;
                }

                sum = 0;
                continue;
            }
            if (sum == 0) start = i;

            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;

                ansS = start;
                ansE = i;
            }else if (sum == maxSum) {
                //if current subarray is greater than the previous one
                int currLen = i - start + 1;
                int bestLen = ansE - ansS + 1;

                if (bestLen < currLen) {
                    ansS = start;
                    ansE = i;
                }
//               no need of this
//                else if (currLen == bestLen) {//if they both are equal then check first element
//                    if (ansS > start) {
//                        ansS = start;
//                        ansE = i;
//                    }
//                }
            }
        }
        
        //all negative case
        if (ansS == -1) return new ArrayList<>(List.of(-1));

        for (int i = ansS; i <= ansE; i++) {
            list.add(arr[i]);
        }

        return list;
    }
}
