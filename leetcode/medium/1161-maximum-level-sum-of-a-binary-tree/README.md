# Maximum Level Sum of a Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the `root` of a binary tree, the level of its root is `1`, the level of its children is `2`, and so on.

Return the  **smallest**  level `x` such that the sum of all the values of nodes at level `x` is  **maximal**.

 

 **Example 1:** 

```
Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

```

 **Example 2:** 

```
Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [1, 104].
- -105 <= Node.val <= 105

## Solution

**Language:** Java  
**Runtime:** 10 ms (beats 18.33%)  
**Memory:** 48.9 MB (beats 85.64%)  
**Submitted:** 2026-10-05T06:32:35.525Z  

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
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/)