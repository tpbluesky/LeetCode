package Problem150;

class Solution {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length <= 0) {
            return 0;
        }
        int stack[] = new int[tokens.length];
        int head = 0;
//        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; ++i) {
            String str = tokens[i];
            if (str.equals("+")) {
                int val1 = stack[--head];
                int val2 = stack[--head];
                stack[head++] = val1 + val2;
            } else if (str.equals("-")) {
                int val1 = stack[--head];
                int val2 = stack[--head];
                stack[head++] = val2 - val1;
            } else if (str.equals("*")) {
                int val1 = stack[--head];
                int val2 = stack[--head];
                stack[head++] = val1 * val2;
            } else if (str.equals("/")) {
                int val1 = stack[--head];
                int val2 = stack[--head];
                stack[head++] = val2 / val1;
            } else {
                stack[head++] = Integer.parseInt(str);
            }
        }
        return stack[0];
    }
}