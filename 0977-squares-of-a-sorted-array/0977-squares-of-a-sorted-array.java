class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0;
        int r = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int left = nums[l] * nums[l];
            int right = nums[r] * nums[r];
            if (left > right) {
                res[i] = left;
                l++;
            } else {
                res[i] = right;
                r--;
            }
        }

        return res;
    }
}