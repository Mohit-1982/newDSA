GFG
  Optimal : 
    class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        int n = start.length;
        int m = end.length;
        int[][] sweepArr = new int[n + m][2];
        int k = sweepArr.length;
        int l = 0;
        
        for (int i = 0; i < n; i++) {
            sweepArr[l][0] = start[i];
            sweepArr[l][1] = 1;
            l++;
        }
        
        for (int i = 0; i < m; i++) {
            sweepArr[l][0] = end[i];
            sweepArr[l][1] = -1;
            l++;
        }
        
        Arrays.sort(sweepArr, (a, b) ->
        (a[0] == b[0])
        ? (a[1] - b[1])
        : (a[0] - b[0]));
    
        int roomAlloted = 0;
        int res = 0;
        
        for (int i = 0; i < k; i++) {
            int ele = sweepArr[i][0];
            int stOrEnd = sweepArr[i][1];
            
            roomAlloted += stOrEnd;
            res = Math.max(res, roomAlloted);
        }
        
        return res;
    }
}
