import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int rootIndex, int left, int right, Map<Integer, Integer> map) {
        if (left > right) {
            return null;
        }
        
        int rootValue = preorder[rootIndex];
        TreeNode root = new TreeNode(rootValue);
        int mid = map.get(rootValue);
        root.left = buildTree(preorder, rootIndex + 1, left, mid - 1, map);
        root.right = buildTree(preorder, rootIndex + mid - left + 1, mid + 1, right, map);
        return root;
    }
}
