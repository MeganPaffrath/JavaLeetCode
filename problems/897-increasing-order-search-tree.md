# 897. Increasing Order Search Tree

[Return](../README.md)

Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

Ex1:

```
      5
     /  \
    3     6
   /  \     \
  2   4       8
 /           / \
1           7   9

1
 \
  2
   \
    3
     \
      4
       \
        5
         ....ect.
```

```
Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
```

Constraints:

The number of nodes in the given tree will be in the range [1, 100].
0 <= Node.val <= 1000

# Solution

```Java
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
    public TreeNode increasingBST(TreeNode root) {
        // initialize list of values for new tree
        List<Integer> nodes = new ArrayList();
        inorderTrav(root, nodes);

        // establish rearanged tree
        TreeNode start = new TreeNode(0);
        TreeNode ptr = start;

        for (int node : nodes) {
            ptr.right = new TreeNode(node);
            ptr = ptr.right;
        }

        // return the new tree
        return start.right;
    }

    // inorder traversal: <left><root><right>
    public void inorderTrav(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        // Left Node
        inorderTrav(root.left, inorder);
        // Root Node
        inorder.add(root.val);
        // Right node
        inorderTrav(root.right, inorder);
    }
}
```
