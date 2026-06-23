Leetcode - 1535
  Better :   
    class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int ele : arr) {
            dq.add(ele);
        }

        int choosenEle = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int ele1 = dq.remove();
            int ele2 = dq.remove();

            if (ele1 > ele2) {
                count++;
                choosenEle = ele1;
                dq.addFirst(ele1);
                dq.addLast(ele2);
            } else {
                count = 1;
                choosenEle = ele2;
                dq.addFirst(ele2);
                dq.addLast(ele1);
            }

            if (count == k) return choosenEle;
        }
        // return dq.peekFirst();//the maximum ele now reaches front
        return choosenEle;
    }
}

Optimal :   
  class Solution {
    public int getWinner(int[] arr, int k) {
        int wins = 0;
        int ans = arr[0];
        int n = arr.length;
        
        for (int i = 1; i < n && wins < k; i++) {
            if (ans < arr[i]) {
                ans = arr[i];
                wins = 1;
            } else {
                wins++;
            }

            // if (wins == k) return ans;
        }

        return ans;
    }
}
