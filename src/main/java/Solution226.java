public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        preorder(root);
        return root;
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        preorder(root.left);
        preorder(root.right);
    }
}
