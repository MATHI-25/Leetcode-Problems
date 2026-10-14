class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n];
        boolean[] diagonal2 = new boolean[2 * n];

        solve(0, n, col, diagonal1, diagonal2);

        return count;
    }

    void solve(int row, int n, boolean[] col,
               boolean[] diagonal1, boolean[] diagonal2) {

        if (row == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = row - c + n;
            int d2 = row + c;

            if (col[c] || diagonal1[d1] || diagonal2[d2]) {
                continue;
            }

            col[c] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;

            solve(row + 1, n, col, diagonal1, diagonal2);

            col[c] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }
}
