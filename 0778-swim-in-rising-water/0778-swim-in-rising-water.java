class Solution {

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        boolean[][] visited = new boolean[n][n];

        // {height, row, column}
        pq.offer(new int[]{grid[0][0], 0, 0});

        int water = 0;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int height = current[0];
            int row = current[1];
            int col = current[2];

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            // Water must be at least this height
            water = Math.max(water, height);

            // Reached destination
            if (row == n - 1 && col == n - 1) {
                return water;
            }

            // Check 4 directions
            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < n &&
                    !visited[newRow][newCol]) {

                    pq.offer(new int[]{
                        grid[newRow][newCol],
                        newRow,
                        newCol
                    });
                }
            }
        }

        return -1;
    }
}