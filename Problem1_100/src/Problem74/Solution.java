package Problem74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        System.out.println(n);
        int m = n == 0 ? 0 : matrix[0].length;
        if (n == 0 || m == 0) return false;
        int l = 0, r = n * m - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int x = mid / m, y = mid % m;
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}
