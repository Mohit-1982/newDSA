WRONG:
  class Solution {
    public String minWindow(String s, String t) {
        int sCount = 0;
        int n = s.length();
        int m = t.length();
        int tCount = m;
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder("!");
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        if (n < m) return sb.toString();

        for (int high = 0; high < n; high++) {
            sb.append(s.charAt(high));
            if (tMap.containsKey(s.charAt(high))) {
                sMap.put(s.charAt(high), sMap.getOrDefault(s.charAt(high), 0) + 1);
                sCount++;
            }

            while (sCount == tCount && sMap.size() == tMap.size()) {
                if (sMap.containsKey(sb.charAt(0))) {
                    if (sMap.get(sb.charAt(0)) <= 1) sMap.remove(sb.charAt(0));
                    else sMap.put(sb.charAt(0), sMap.get(sb.charAt(0)) - 1);
                    sCount--;
                }
                
                if (res.toString().equals("!") || sb.length() < res.length()) {
                    res = new StringBuilder(sb);
                }
                sb.deleteCharAt(0);
            }
        }
        
        return (res.toString().equals("!")) ? "" : res.toString();
    }
}

Optimal : 
  class Solution {
    public String minWindow(String s, String t) {
        int low = 0;
        int lowS = -1;
        int highE = -1;
        int n = s.length();
        int m = t.length();
        int[] sArr = new int[256];
        int[] tArr = new int[256];

        if (m > n) return "";

        for (int i = 0; i < m; i++) {
            tArr[t.charAt(i)]++;
        }

        for (int high = 0; high < n; high++) {
            sArr[s.charAt(high)]++;

            while (check(sArr, tArr)) {
                if (lowS == -1 || (highE - lowS) > (high - low)) {
                    lowS = low;
                    highE = high;
                }

                sArr[s.charAt(low)]--;
                low++;
            }
        }

        return (lowS != -1) ? s.substring(lowS, highE + 1) : "";
    }

    public boolean check(int[] sArr, int[] tArr) {
        for (int i = 0; i < 256; i++) {
            if (tArr[i] != 0 && sArr[i] < tArr[i]) return false;
        }

        return true;
    }
}
