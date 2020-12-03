# 382. Linked List Random Note

[Return](../README.md)

Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

```
// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
```

# Concept

- Math
  - Odds by size of linked list:
    - 1 items: 1/1
    - 2 items: 1/2
    - 3 items: 1/3
    - 4 items: 1/4
- Iterate through the linked list node by node
- For each node, consider making this node the new value to be considered
  - Determine if this node should be considered by randomly generating with odds of 1/size

# Solution

```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode head = null;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode pos = head;
        int value = pos.val;

        // Odds of picking next node = 1/odds
        int odds = 1;

        while (pos.next != null) {
            pos = pos.next;
            odds++;

            if (randomInRange(1, odds) == odds) {
                value = pos.val;
                System.out.println("true, moving to: " + value);
            }
        }
        return value;
    }

    /* Generates a random number in a range between min and max */
    public int randomInRange(int min, int max) {
        int range = (max-min) + 1;
        return ((int)(Math.random() * range) + min);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
```
