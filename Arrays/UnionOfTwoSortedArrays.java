GFG
  Brute : 
    class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        
        for (int i = 0; i < m; i++) {
            set.add(b[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int ele : set) {
            list.add(ele);
        }
        
        return list;
    }
}

Optimal :   
  class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int i = 0;
        int j = 0;
        int n = a.length;
        int m = b.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        while (i < n && j < m) {
            if (res.isEmpty()) {
                if (a[i] <= b[j]) {
                    res.add(a[i++]);
                }else {
                    res.add(b[j++]);
                }
            }else if (a[i] <= b[j]) {
                if (res.get(res.size() - 1) != a[i]) {
                    res.add(a[i]);
                }
                i++;
            }else {
                if (res.get(res.size() - 1) != b[j]) {
                    res.add(b[j]);
                }
                j++;
            }
        }
        
        while (i < n) {
            if (res.isEmpty()) {
                res.add(a[i++]);
            }
            else if (res.get(res.size() - 1) != a[i]) {
                res.add(a[i++]);
            }
            else {
                i++;
            }
        }
        
        while (j < m) {
            if (res.isEmpty()) {
                res.add(b[j++]);
            }
            else if (res.get(res.size() - 1) != b[j]) {
                res.add(b[j++]);
            }else {
                j++;
            }
        }
        
        return res;
    }
}
