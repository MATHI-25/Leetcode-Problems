class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;

        // Find total sum
        for (int num : nums) {
            sum += num;
        }

        // Odd sum cannot be divided equally
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        // dp[i] = can we make sum i?
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int num : nums) {

            for (int i = target; i >= num; i--) {

                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }
}