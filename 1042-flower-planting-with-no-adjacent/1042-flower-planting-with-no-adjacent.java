import java.util.*;
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] answer = new int[n + 1];

        for (int garden = 1; garden <= n; garden++) {
            boolean[] used = new boolean[5];

            for (int neighbor : graph[garden]) {
                used[answer[neighbor]] = true;
            }

            for (int flower = 1; flower <= 4; flower++) {
                if (!used[flower]) {
                    answer[garden] = flower;
                    break;
                }
            }
        }

        return Arrays.copyOfRange(answer, 1, n + 1);
    }
}
