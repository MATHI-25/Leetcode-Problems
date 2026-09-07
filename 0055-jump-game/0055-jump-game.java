class Solution {
    public boolean canJump(int[] nums) {

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // If we cannot reach this index
            if (i > farthest) {
                return false;
            }

            // Find the farthest index we can reach
            farthest = Math.max(farthest, i + nums[i]);
        }

        return true;
    }
}