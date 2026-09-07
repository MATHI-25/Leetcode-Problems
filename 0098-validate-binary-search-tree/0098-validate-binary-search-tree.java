class Solution {

    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        // Check left subtree
        if (!isValidBST(root.left)) {
            return false;
        }

        // Check current node
        if (prev != null && root.val <= prev.val) {
            return false;
        }

        prev = root;

        // Check right subtree
        return isValidBST(root.right);
    }
}