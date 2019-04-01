package Problem71;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        System.out.println(Arrays.toString(strings));
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strings.length; ++i) {
            if (strings[i].equals(".") || strings[i].equals((""))) continue;
            if (strings[i].equals("..")) {
                if (!stack.empty()) stack.pop();
            } else stack.push(strings[i]);
        }
        StringBuffer ans = new StringBuffer();
        ans.append("/");
        int size = stack.size();
        for (int i = 0; i < size; ++i) {
            ans.append(stack.get(i));
            if (i != size - 1) ans.append("/");
        }
        return ans.toString();
    }
}
