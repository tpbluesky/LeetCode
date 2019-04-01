package Problem263;

class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        int val[] = {2, 3, 5};
        for (int i = 0; i < val.length; ++i) {
            while (num % val[i] == 0) {
                num /= val[i];
            }
        }
        return num == 1;
    }
}