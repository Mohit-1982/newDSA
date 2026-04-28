Leetcode - 1742
  Using HashMaps : 
    class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int n = -1;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = lowLimit; i <= highLimit; i++) {
            n = digitSum(i);
            if (!map.containsKey(n)) {
                map.put(n, 1);
            }else {
                int freq = map.get(n);
                map.put(n, freq + 1);
            }

            if (map.get(n) > max) {
                max = map.get(n);
            }
        }

        return max;
    }

    public int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}

Using Arrays : 
    class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int n = -1;
        int max = 0;
        int[] box = new int[46];//highLimit + 1

        for (int i = lowLimit; i <= highLimit; i++) {
            n = digitSum(i);
            box[n]++;
            max = Math.max(max, box[n]);
        }

        return max;
    }

    public int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
