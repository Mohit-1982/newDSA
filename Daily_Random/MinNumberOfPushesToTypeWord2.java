Leetcode - 3016
  Better: O(n + m^2)
    class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }

        int m = map.size();
        int count = 0;
        int res = 0;
        int mul = 1;

        for (int i = 0; i < m; i++) {
            char ch = findMax(map);
            res += mul * map.get(ch);
            count++;
            map.remove(ch);

            if (count % 8 == 0) mul++;
        }

        return res;
    }

    public char findMax(Map<Character, Integer> map) {
        int max = 0;
        char res = ' ';

        for (char ch : map.keySet()) {
            if (map.get(ch) > max) {
                max = map.get(ch);
                res = ch;
            }
        }

        return res;
    }
}

Optimal: 
  class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] store = new int[26];

        for (int i = 0; i < n; i++) {
            store[word.charAt(i) - 'a']++;
        }

        Arrays.sort(store);

        int count = 0;
        int res = 0;
        int mul = 1;

        for (int i = store.length - 1; i >= 0; i--) {
            if (store[i] == 0) break;

            res += mul * store[i];
            count++;

            if (count % 8 == 0) mul++;
        }

        return res;
    }
}
