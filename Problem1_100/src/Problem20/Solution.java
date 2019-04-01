package Problem20;

import java.util.Scanner;
import java.util.Stack;

class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char t = s.charAt(i);
            if (t == ']' || t == ')' || t == '}') {
                if (stack.empty()) return false;
                if (t == ')' && stack.peek() != '(') return false;
                if (t == ']' && stack.peek() != '[') return false;
                if (t == '}' && stack.peek() != '{') return false;
                stack.pop();
                continue;
            }
            stack.push(t);
        }
        return stack.empty();
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            System.out.println(new Solution().isValid(sin.nextLine()));
        }
    }
}