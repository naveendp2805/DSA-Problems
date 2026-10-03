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
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    private static int countGoodNodes(TreeNode root, int max)
    {
        if(root == null) return 0;

        int c = 0;

        if(root.val >= max)
            c = 1;

        max = Math.max(max, root.val);

        c += countGoodNodes(root.left, max);
        c += countGoodNodes(root.right, max);

        return c;
    } 
}