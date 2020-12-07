# 117 Populating Next Right Pointers in Each Node II

[Return](../README.md)

# Problem

```
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
```

Example 1:

```
             1 -> null
            / \
          2 -> 3 -> null
        /  \     \
       4 -> 5 --> 7 -> null



Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
```

```
Constraints:

The number of nodes in the given tree is less than 6000.
-100 <= node.val <= 100


```

# Solution

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
        // check if null
        if (root == null) {
            return root;
        }

        // use queue to keep track of tree
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (q.size() > 0) {
            // for each level, connect nodes
            int lvlSize = q.size();

            // go through these nodes
            for (int i = 0; i < lvlSize; i++) {
                // get first node
                Node node = q.poll();

                // for each node of this level, connect to next if it exists
                if (i < (lvlSize - 1) )  {
                    node.next = q.peek();
                }

                // add children
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return root;
    }


}
```
