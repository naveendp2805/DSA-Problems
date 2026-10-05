/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        return dfs(root, 0L, targetSum, map);
    }

    private static int dfs(TreeNode root, Long prefixSum, int target, Map<Long, Integer> map)
    {
        if(root == null)
            return 0;

        prefixSum += root.val;

        int res = map.getOrDefault(prefixSum - target, 0);

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        res += dfs(root.left, prefixSum, target, map);
        res += dfs(root.right, prefixSum, target, map);

        map.put(prefixSum, map.get(prefixSum) - 1);

        return res;
    }
}