# Longest ZigZag Path in a Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given the `root` of a binary tree.

A ZigZag path for a binary tree is defined as follow:

- Choose any node in the binary tree and a direction (right or left).
- If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
- Change the direction from right to left or from left to right.
- Repeat the second and third steps until you can't move in the tree.

Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return  *the longest  **ZigZag**  path contained in that tree*.

 

 **Example 1:** 

```
Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).

```

 **Example 2:** 

```
Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).

```

 **Example 3:** 

```
Input: root = [1]
Output: 0

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [1, 5 * 104].
- 1 <= Node.val <= 100

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 63.43%)  
**Memory:** 58.2 MB (beats 34.68%)  
**Submitted:** 2026-10-05T06:01:32.006Z  

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

    int res = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return res;
    }

    private void dfs(TreeNode root, int left, int right)
    {
        if(root == null)
            return;

        res = Math.max(res, Math.max(left, right));

        dfs(root.left, right + 1, 0);
        dfs(root.right, 0, left + 1);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/)