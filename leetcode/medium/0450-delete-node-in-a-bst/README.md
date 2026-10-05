# Delete Node in a BST

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return  *the  **root node reference**  (possibly updated) of the BST*.

Basically, the deletion can be divided into two stages:

- Search for a node to remove.
- If the node is found, delete the node.

 

 **Example 1:** 

```
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

```

 **Example 2:** 

```
Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.

```

 **Example 3:** 

```
Input: root = [], key = 0
Output: []

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [0, 104].
- -105 <= Node.val <= 105
- Each node has a unique value.
- root is a valid binary search tree.
- -105 <= key <= 105

 

 **Follow up:**  Could you solve it with time complexity `O(height of tree)`?

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 47.3 MB (beats 89.24%)  
**Submitted:** 2026-10-05T06:50:42.087Z  

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
```

---

[View on LeetCode](https://leetcode.com/problems/delete-node-in-a-bst/)