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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        TreeNode curr = root, par = null;

        while(curr != null && curr.val != key)
        {
            par = curr;

            curr = key < curr.val ? curr.left : curr.right;
        }

        if(curr == null)
            return root;
        else if(curr.left == null && curr.right == null)
        {
            if(par == null)
                return null;
            
            if(par.left == curr)
                par.left = null;
            else
                par.right = null;
        }
        else if(curr.right == null)
        {
            if(par == null)
                return curr.left;
            
            if(par.left == curr)
                par.left = curr.left;
            else
                par.right = curr.left;
        }
        else if(curr.left == null)
        {
            if(par == null)
                return curr.right;

            if(par.left == curr)
                par.left = curr.right;
            else
                par.right = curr.right;
        }
        else
        {
            TreeNode p = null, p1 = curr.right;

            while(p1.left != null)
            {
                p = p1;
                p1 = p1.left;
            }

            curr.val = p1.val;

            if(p == null)
                curr.right = p1.right;
            else
                p.left = p1.right;
        }

        return root;
    }
}