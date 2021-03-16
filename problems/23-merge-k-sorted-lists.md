23. Merge k Sorted Lists

[Return](../README.md)

# Instructions
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

```
Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
```
```
Example 2:

Input: lists = []
Output: []
```
```
Example 3:

Input: lists = [[]]
Output: []
 ```

Constraints:

- k == lists.length
- 0 <= k <= 10^4
- 0 <= lists[i].length <= 500
- -10^4 <= lists[i][j] <= 10^4
- lists[i] is sorted in ascending order.
- The sum of lists[i].length won't exceed 10^4.

# Best solution
- Use min heap


# Solution - Next
- O(nlogn)
- create a sorted list of all nodes
  - O(nlogn)
- append nodes to LL one by one
  - O(n)

# Solution - Bad
- Bruteforce
- Time: O(n^3) ?
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode left = head;
        ListNode right = head.next;
        
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                if (right == null || curr.val <= right.val) {
                    ListNode newN = new ListNode(curr.val);
                    newN.next = right;
                    left.next = newN;
                    curr = curr.next;
                } 
                left = left.next;
                right = left.next;
            }
            left = head;
            right = head.next;
            
        }
        
        return head.next;
    }
}
```