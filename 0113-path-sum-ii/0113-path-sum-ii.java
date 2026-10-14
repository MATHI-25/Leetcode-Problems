import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findPaths(root, targetSum);
        return result;
    }

    public void findPaths(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(path));
        }

        findPaths(root.left, sum);
        findPaths(root.right, sum);

        path.remove(path.size() - 1);
    }
}
