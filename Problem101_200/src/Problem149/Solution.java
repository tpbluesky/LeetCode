package Problem149;

import java.util.HashMap;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}


public class Solution {

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public Point calcK(Point a, Point b) {
        int xx = a.x - b.x;
        int yy = a.y - b.y;
        int t = gcd(xx, yy);
        Point p = new Point(t == 0 ? xx : xx / t, t == 0 ? yy : yy / t);
        return p;
    }

    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;
        int ans = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            HashMap<String, Integer> map = new HashMap<>();
            int same_point = 0;
            for (int j = i + 1; j < points.length; ++j) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    same_point++;
                    continue;
                }
                Point p = calcK(points[i], points[j]);
                String str = p.x + "_" + p.y;
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            int res = 0;
            for (Integer value : map.values()) {
                res = Math.max(res, value);
            }
            ans = Math.max(res + same_point, ans);
        }
        return ans + 1;
    }
}
