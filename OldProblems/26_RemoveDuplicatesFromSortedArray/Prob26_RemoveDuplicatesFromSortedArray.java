package com.meganpaffrath;

/**
 * IMPROVE RUNTIME
 *
 * Runtime: 51 ms, faster than 5.05% of Java online submissions for Remove Duplicates from Sorted Array.
 * Memory Usage: 39.9 MB, less than 81.38% of Java online submissions for Remove Duplicates from Sorted Array.
 */

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 *      Given nums = [1,1,2],
 *
 *      Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 *      It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 *
 *      Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 *      Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 *      It doesn't matter what values are set beyond the returned length.
 *
 * Clarification:
 *
 *      Confused why the returned value is an integer but your answer is an array?
 *
 *      Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 *      Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 *      for (int i = 0; i < len; i++) {
 *          print(nums[i]);
 *      }
 */

public class Prob26_RemoveDuplicatesFromSortedArray {
    int length;
    public void shift(int removeLoc, int[] nums) {
        for (int i = removeLoc; i < nums.length - 1; i++) {
            nums[i] = nums[i+1];
            // ideally would shift array over
        }
        // System.out.print("ARR: ");
        // show(nums);
        // System.out.println();
    }

    public void show(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        int prevVal = nums[0];
        for (int i = 1; i < length; i++) {
            // System.out.println(i-1 + ": " + nums[i-1] + " and " + i + ": " + nums[i]);
            if (nums[i-1] == nums[i]) {
                shift(i, nums);
                length--;
                i--;
            }

        }
        return length;
    }
}
