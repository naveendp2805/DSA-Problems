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
    int postIndex;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        postIndex = postorder.length - 1;
        map = new HashMap<>();

        int n = inorder.length;

        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, n - 1);
    }

    private TreeNode build(int[] postorder, int start, int end) {

        if(start > end) return null;

        int val = postorder[postIndex--];

        TreeNode root = new TreeNode(val);

        int mid = map.get(val);

        root.right = build(postorder, mid + 1, end);
        root.left = build(postorder, start, mid - 1);

        return root;
    }
}