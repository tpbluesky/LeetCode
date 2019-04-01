package Problem43;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] n1 = num1.toCharArray();
        String ans = "0";
        String t = "";
        for (int i = n1.length - 1; i >= 0; --i) {
            ans = add(ans, mulOne(n1[i] - '0', num2) + t);
            t += '0';
        }
        return ans;
    }

    private String mulOne(int x, String s) {
        int i = s.length() - 1;
        StringBuffer sb = new StringBuffer();
        int prev = 0;
        while (i >= 0) {
            int res = (s.charAt(i) - '0') * x + prev;
            sb.append(res % 10);
            prev = res / 10;
            i--;
        }
        if (prev > 0) sb.append(prev);
        return sb.reverse().toString();
    }

    private String add(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        StringBuffer sb = new StringBuffer();
        int pre = 0;
        while (i >= 0 || j >= 0) {
            int res = (i >= 0 ? (s1.charAt(i) - '0') : 0) + (j >= 0 ? (s2.charAt(j) - '0') : 0) + pre;
            sb.append(res % 10);
            pre = res / 10;
            i--;
            j--;
        }
        if (pre > 0) sb.append(pre);
        return sb.reverse().toString();
    }

    public String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int tmp[] = new int[len1 + len2];
        for (int i = 0; i < len1; i++) {
            int n1 = (num1.charAt(len1 - 1 - i) - '0');
            for (int j = 0; j < len2; j++) {
                tmp[i + j] += n1 * (num2.charAt(len2 - j - 1) - '0');
            }
        }
        int pre = 0;
        for (int i = 0; i < tmp.length; ++i) {
            int res = tmp[i] + pre;
            tmp[i] = res % 10;
            if (i + 1 < tmp.length) tmp[i + 1] += res / 10;
        }
        StringBuffer sb = new StringBuffer();
        int x = tmp.length - 1;
        while (tmp[x] == 0) x--;
        for (; x >= 0; x--) {
            sb.append(tmp[x]);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        System.out.println(new Solution().mulOne(2, "3"));
    }
}