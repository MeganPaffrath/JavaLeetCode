# 33. Search in Rotated Sorted Array

[Return](../README.md)

# Instructions
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

```
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```
```
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```
```
Example 3:

Input: nums = [1], target = 0
Output: -1
```

Constraints:

- 1 <= nums.length <= 5000
- -104 <= nums[i] <= 104
- All values of nums are unique.
- nums is guaranteed to be rotated at some pivot.
- -104 <= target <= 104


# Solution: O(nlogn)
- binary search algorithm
- Time: O(nlogn)
```Java
class Solution {
    public int search(int[] nums, int target) {
        int pivot = pivotPoint(nums);
        
        System.out.println("Pivot: " + pivot);
        
        return getPos(nums, target, pivot);
        
    }
    
    public int pivotPoint(int[] nums) {
        int left = 0;
        int right = nums.length - 1; 
        int mid;
        
        int min = Integer.MAX_VALUE;
        int minI = Integer.MAX_VALUE;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            
            if (min > nums[mid]) {
                min = nums[mid];
                minI = mid;
            }
            
            if (nums[mid] > nums[right]) { // search right
                left = mid + 1;
            } else if (nums[left] < nums[mid] && nums[left] < min) { // search left
                return left;
            } else { // search right
                right = mid - 1;
            }
        }
        
        return minI;
    }
    
    public int getPos(int[] nums, int target, int pivot) {
        int left = 0;
        int right = nums.length - 1;
        int mid = pivot;
        
        while (left <= right) {
            if (target == nums[mid]) {
                return mid;
            }
            
            // if right of mid
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1;
            } else { // if left of mid
                right = mid - 1;
            }

            // set mid for next iteration
            mid = left + (right - left) / 2;
        }
        
        return -1;
    }
}
```

# Solution: O(n)
- Time: O(n)
```Java
class Solution {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
```

# Solution: O(n)
- Time: O(n)
```Java
class Solution {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
```