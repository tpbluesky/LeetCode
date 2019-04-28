package Problem134;

public class Solution {
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            if (gas[i] >= cost[i]) {
                int left = gas[i] - cost[i];
                int j = (i + 1) % len;
                while (j != i && left + gas[j] >= cost[j]) {
                    left = left + gas[j] - cost[j];
                    j = (j + 1) % len;
                }
                if (j == i) return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) return -1;
        int len = gas.length, sum = 0;
        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) return -1;
        int start = 0;
        for (int i = 0, tmp = 0; i < len; ++i) {
            tmp += gas[i] - cost[i];
            if (tmp < 0) {
                tmp = 0;
                start = i + 1;
            }
        }
        return start;
    }
}