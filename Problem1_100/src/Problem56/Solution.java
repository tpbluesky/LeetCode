package Problem56;

import java.util.ArrayList;
import java.util.Collections;
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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        List<Interval> ans = new ArrayList<>();
        Collections.sort(intervals, (x, y) -> {
            return x.start - y.start;
        });
        int start = intervals.get(0).start, end = intervals.get(0).end;
        int len = intervals.size();
        for (int i = 1; i < len; ++i) {
            Interval t = intervals.get(i);
            if (t.start <= end) end = Math.max(t.end, end);
            else {
                ans.add(new Interval(start, end));
                start = t.start;
                end = t.end;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}