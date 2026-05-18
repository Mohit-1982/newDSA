Leetcode - 3136
  Optimal : 
    class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        int chara = 0;
        boolean vowel = false;
        boolean conso = false;

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            chara++;

            if (isVowel(ch)) {
                vowel = true;
            }else if (isConso(ch)) {
                conso = true;
            }else if (!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }

        if (chara < 3 || !vowel || !conso) return false;
        return true;
    }

    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        else return false;
    }

    public boolean isConso(char ch) {
        ch = Character.toLowerCase(ch);

        return ch >= 'a' && ch <= 'z' && !isVowel(ch);
    }
}
