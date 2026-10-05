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
    public int maxLevelSum(TreeNode root) {
        int res = 1, max = Integer.MIN_VALUE, level = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int n = q.size();
            int sum = 0;

            for(int i=1; i<=n; i++)
            {
                TreeNode node = q.poll();

                sum += node.val;

                if(node.left != null)
                    q.offer(node.left);
                
                if(node.right != null)
                    q.offer(node.right);
            }

            if(sum > max)
            {
                max = sum;
                res = level;
            }

            level++;
        }

        return res;
    }
}