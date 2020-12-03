# 116 Populating next right pointers in each node

[Return](../README.md)

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

```
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

```
Follow up:

- You may only use constant extra space.
- Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
```

Ex1:

```
          1   --> NULL
        /    \
      2   ->   3  --> NULL
    /   \     /  \
   4 -> 5 -> 6 -> 7 --> NULL

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
```

# Solution:

```Java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // Make left child point to right child
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = null;
            }
            // rec call to try for left node
            connect(root.left);
        }

        // make right child point to next's left child
        if (root.right != null) {
            if (root.next != null && root.next.left != null) {
                root.right.next = root.next.left;
            }
            // rec call to try for right node
            connect(root.right);
        }

        return root;
    }
}
```
