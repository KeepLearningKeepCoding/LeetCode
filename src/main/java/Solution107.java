import java.util.*;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                tmp.add(p.val);
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            list.add(tmp);
        }
        Collections.reverse(list);
        return list;
    }
}
