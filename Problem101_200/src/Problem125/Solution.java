package Problem125;

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;
        while (i < j) {
            while (i < j && !Character.isAlphabetic(str[i]) && !Character.isDigit(str[i])) i++;
            while (i < j && !Character.isAlphabetic(str[j]) && !Character.isDigit(str[j])) j--;
            if (str[i] != str[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
