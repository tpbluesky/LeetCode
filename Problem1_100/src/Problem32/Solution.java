package Problem32;

import java.util.Stack;

class Solution {

    public int longestValidParentheses1(String s) {
        int lens = s.length();
        int maxLen = lens % 2 == 0 ? lens : lens - 1;
        for (int i = maxLen; i >= 2; i -= 2) {
            for (int j = 0; j + i <= lens; j++) {
                if (s.charAt(j) == '(' && s.charAt(j + i - 1) == ')' && isvavid(s.substring(j, j + i))) return i;
            }
        }
        return 0;
    }

    private boolean isvavid(String s) {
        int lens = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < lens; ++i) {
            char t = s.charAt(i);
            if (t == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
                continue;
            }
            stack.push(t);
        }
        return stack.isEmpty();
    }


    public int longestValidParentheses2(String s) {
        int lens = s.length();
        if (lens <= 1) return 0;
        int l = 0, r = 0, maxCnt = 0;
        for (int i = 0; i < lens; i++) {
            if (s.charAt(i) == '(') l++;
            else r++;
            if (l == r) maxCnt = Math.max(maxCnt, 2 * r);
            else if (l <= r) l = r = 0;
        }
        l = r = 0;
        for (int i = lens - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') r++;
            else l++;
            if (l == r) maxCnt = Math.max(maxCnt, 2 * l);
            else if (l >= r) l = r = 0;
        }
        return maxCnt;
    }

    public int longestValidParentheses(String s) {
        int lens = s.length();
        if (lens <= 1) return 0;
        int maxCnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < lens; ++i) {
            if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxCnt = Math.max(maxCnt, i - stack.peek());
                }
            } else {
                stack.push(i);
            }
        }
        return maxCnt;
    }


}