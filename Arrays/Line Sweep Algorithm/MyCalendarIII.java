Leetcode - 732
  Sweep Line : 
    class MyCalendarThree {
    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);
        int max = 0;
        int curr = 0;

        for (int ele : map.keySet()) {
            curr += map.get(ele);
            max = Math.max(curr, max);
        }

        return max;
    }
}
