# Q2. Construct Binary Tree from Inorder and Postorder Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two integer arrays `inorder` and `postorder` where `inorder` is the inorder traversal of a binary tree and `postorder` is the postorder traversal of the same tree, construct and return  *the binary tree*.

 

Original
Java
 **Example 1:** 

```
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

```

 **Example 2:** 

```
Input: inorder = [-1], postorder = [-1]
Output: [-1]

```

 

 **Constraints:** 

- 1 <= inorder.length <= 3000
- postorder.length == inorder.length
- -3000 <= inorder[i], postorder[i] <= 3000
- inorder and postorder consist of unique values.
- Each value of postorder also appears in inorder.
- inorder is guaranteed to be the inorder traversal of the tree.
- postorder is guaranteed to be the postorder traversal of the tree.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 86.17%)  
**Memory:** 46.5 MB (beats 22.52%)  
**Submitted:** 2026-11-27T05:09:51.454Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)