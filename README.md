# Coding Problems

Reviewing old code pairs well with morning coffee/tea ;)

## Leetcode - DS & Alg

- [1. Two Sum](problems/1-two-sum.md)
- [15. 3Sum](problems/15-3-sum.md)
- [17. Letter Combinations of a Phone Number](problems/17-letter-combinations-of-a-phone-number.md)
- [23. Merge k Sorted Lists](problems/23-merge-k-sorted-lists.md) : Linked list, min heap
- [33. Search in Rotated Sorted Array](problems/33-search-in-rotated-sorted-array.md) : Binary Search
- [42. Trapping Rain Water](problems/42-trapping-rain-water.md) : Array, Dynamic Programming
- [53. Maximum Subarray](problems/53-maximum-subarray.md) : Array, Kadane's Algorithm
- [66. Plus One](problems/66-plus-one.md)
- [102. Binary Tree Level Order Traversal](problems/102-binary-tree-level-order-traversal.md) : Tree traversal
- [104. Maximum Depth of Binary Tree](problems/104-max-depth-binary-tree.md) : Binary Tree
- [116. Populating next right pointers in each node](problems/116-propulating-next-pointers-in-each-node.md) : Binary Tree
- [117 Populating Next Right Pointers in Each Node II](problems/117-populating-next-right-pointers-in-each-node.md) : Binary tree, queue, bfs
- [125. Valid Palindrome](problems/125-valid-palindrome.md) : String manipulation
- [165. Compare Version Numbers](problems/165-compare-version-numbers.md) : Parse string, array
- [167. Two Sum II](problems/167-two-Sum-II.md)
- [200. Number of Islands](problems/200-number-of-islands.md) : 2d Array, Recursion
- [243. Shortest Word Distance](problems/243-shortest-word-distance.md) : Array iteration
- [344. Reverse String](problems/344-reverse-string.md) : Array manipulation
- [382. Linked List Random Note](problems/382-linked-list-random-note.md) : Linked List
- [543. Diameter of Binary Tree](problems/543-diameter-of-binary-tree.md) : Binary tree, recursion
- [605. Can Plant Flowers](problems/605-can-plant-flowers.md) : Array, DeMorgan's Law
- [897. Increasing Order Search Tree](problems/897-increasing-order-search-tree.md) : Binary Tree (inorder traversal)
- [977. Find the Town Judge](problems/997-find-town-judge.md) : Arrays & bad use of hashmap
- [1492. The kth Factor of n](problems/1492-the-kth-factor-of-n.md) : Math

## SQL

- [175. Combine Two Tables](problems/175-combine-two-tables.md)
- [181. Employees Earning More Than Their Managers](problems/181-employees-earning-more-than-their-managers.md)

## Quick Tips

- Letters and Characters

  ```Java
  Character.isDigit('9'); // returns true
  Character.isLetter('A'); // returns true
  Character.toLowerCase('A'); // returns 'a'

  ```

- Hashmaps

  ```Java
  HashMap<String, Integer> myMap = new HashMap<String, Integer>();
  myMap.containsKey("aKey"); // boolean
  myMap.put("Key", 24); // places key and value

  // iterate by key values
  for (String key : map.keySet()) {

  }

  // iterate by value only
  for (Integer value : map.values() ) {

  }

  ```


# Solutions to improve upon:
- 53: maximum subarray
  - get to time: O(nlogn)