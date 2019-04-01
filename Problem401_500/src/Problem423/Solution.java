package Problem423;

public class Solution {
    private final String numbers[] = {"zero", "one", "two",
            "three", "four", "five", "six", "seven", "eight", "ninr"};
    private final String digits = "0624853791";
    private final String dchars = "zxwugfhsin";

    public String originalDigits(String s) {
        char[] chars = s.toCharArray();
        int nums[] = new int[26];
        int ans[] = new int[10];
        for (char aChar : chars) {
            nums[aChar - 'a']++;
        }
        for (int i = 0; i < digits.length(); ++i) {
            char c = digits.charAt(i);
            int x = c - '0';
            int p = dchars.charAt(i) - 'a';
            if (nums[p] <= 0) continue;
            ans[x] = nums[p];
            for (char v : numbers[x].toCharArray()) {
                nums[v - 'a'] -= ans[x];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < ans[i]; ++j) {
                sb.append((char) ('0' + i));
            }
        }
        return sb.toString();
    }

}
