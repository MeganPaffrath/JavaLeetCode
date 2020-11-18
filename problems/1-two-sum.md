# Two Sum

[Return](../README.md)

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

```
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
```

# Solution

```Java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // create a hash map of key value pairs
        Map<Integer, Integer> map = new HashMap<>();

        // iterate through each item
        for (int i=0; i < nums.length; i++) {
            int solution = target - nums[i];
            // look if solution needed is in the map
            if (map.containsKey(solution)) {
                return new int[] {i, map.get(solution)};
            }

            // otherwise add this value as the key and the index as the value
            map.put(nums[i], i);

        }
        throw new IllegalArgumentException("No sum found");
    }
}
```
