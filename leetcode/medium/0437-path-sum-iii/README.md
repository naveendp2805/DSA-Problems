# Path Sum III

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the `root` of a binary tree and an integer `targetSum`, return  *the number of paths where the sum of the values along the path equals*  `targetSum`.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

 **Example 1:** 

```
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.

```

 **Example 2:** 

```
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [0, 1000].
- -109 <= Node.val <= 109
- -1000 <= targetSum <= 1000

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 97.31%)  
**Memory:** 46.5 MB (beats 14.91%)  
**Submitted:** 2026-10-05T05:45:09.607Z  

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
```

---

[View on LeetCode](https://leetcode.com/problems/path-sum-iii/)