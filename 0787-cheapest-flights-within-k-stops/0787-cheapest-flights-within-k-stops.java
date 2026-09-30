class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = cost.clone();
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                if (cost[from] != Integer.MAX_VALUE) {
                    temp[to] = Math.min(
                        temp[to],
                        cost[from] + price
                    );
                }
            }
            cost = temp;
        }
        if (cost[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return cost[dst];
    }
}