import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        preorder(root, targetSum, 0, list, new ArrayList<>());
        return list;
    }

    private void preorder(TreeNode root, int targetSum, int sum, List<List<Integer>> list, List<Integer> tmp) {
        if (root == null) {
            return;
        }

        sum += root.val;
        tmp.add(root.val);
        if (root.left == null && root.right == null && sum == targetSum) {
            list.add(new ArrayList<>(tmp));
        }
        preorder(root.left, targetSum, sum, list, tmp);
        preorder(root.right, targetSum, sum, list, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
