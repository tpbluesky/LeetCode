package Problem57;

import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();
        int len = intervals.size();
        int start = newInterval.start, end = newInterval.end;
        boolean insert = false;
        for (int i = 0; i < len; ++i) {
            Interval t = intervals.get(i);
            if (t.end < start) {
                ans.add(t);
            } else if (t.start > end) {
                if (!insert) {
                    ans.add(new Interval(start, end));
                    insert = true;
                }
                ans.add(t);
            } else {
                start = Math.min(t.start, start);
                end = Math.max(t.end, end);
            }
        }
        if (!insert) ans.add(new Interval(start, end));
        return ans;
    }
}