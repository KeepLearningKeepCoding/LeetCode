public class Solution112 {
    private boolean hasPathSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        preorder(root, targetSum, 0);
        return hasPathSum;
    }

    private void preorder(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return;
        }

        sum += root.val;
        if (root.left == null && root.right == null && sum == targetSum) {
            hasPathSum = true;
            return;
        }
        preorder(root.left, targetSum, sum);
        preorder(root.right, targetSum, sum);
    }
}
