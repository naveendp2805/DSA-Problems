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
    static int res = 0;

    public int averageOfSubtree(TreeNode root) {
        res = 0;
        int[] ans = dfs(root);
        return res;
    }

    private static int[] dfs(TreeNode root)
    {
        if(root == null) return new int[] {0, 0};

        int[] leftSubtree = dfs(root.left);
        int[] rightSubtree = dfs(root.right);

        int sum = leftSubtree[0] + rightSubtree[0] + root.val;
        int count = leftSubtree[1] + rightSubtree[1] + 1;

        if((sum / count) == root.val) res++;

        return new int[] {sum, count};
    }
}