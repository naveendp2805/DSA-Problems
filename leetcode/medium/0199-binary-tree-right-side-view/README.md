# Binary Tree Right Side View

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the `root` of a binary tree, imagine yourself standing on the  **right side**  of it, return  *the values of the nodes you can see ordered from top to bottom*.

 

 **Example 1:** 

 **Input:**  root = [1,2,3,null,5,null,4]

 **Output:**  [1,3,4]

 **Explanation:** 

 **Example 2:** 

 **Input:**  root = [1,2,3,4,null,null,null,5]

 **Output:**  [1,3,4,5]

 **Explanation:** 

 **Example 3:** 

 **Input:**  root = [1,null,3]

 **Output:**  [1,3]

 **Example 4:** 

 **Input:**  root = []

 **Output:**  []

 

 **Constraints:** 

- The number of nodes in the tree is in the range [0, 100].
- -100 <= Node.val <= 100

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 73.05%)  
**Memory:** 43.5 MB (beats 68.85%)  
**Submitted:** 2026-10-05T06:26:29.566Z  

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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root == null)
            return res; 

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int n = queue.size();

            for(int i=1; i<=n; i++)
            {
                TreeNode node = queue.poll();

                if(i == n)
                    res.add(node.val);

                if(node.left != null)
                    queue.offer(node.left);
                
                if(node.right != null)
                    queue.offer(node.right);
            }
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/binary-tree-right-side-view/)