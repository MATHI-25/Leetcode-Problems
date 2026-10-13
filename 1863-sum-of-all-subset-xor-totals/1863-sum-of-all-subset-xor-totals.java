class Solution {
    public int subsetXORSum(int[] nums) {
        return findSum(nums, 0, 0);
    }
    private int findSum(int[] nums, int index, int xor) {
        if (index == nums.length) {
            return xor;
        }

        int include = findSum(nums, index + 1, xor ^ nums[index]);
        int exclude = findSum(nums, index + 1, xor);

        return include + exclude;
    }
}
