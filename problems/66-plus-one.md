# Plus One

[Return](../README.md)

Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

```
Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]
```

Constraints:

- 1 <= digits.length <= 100
- 0 <= digits[i] <= 9

# Solution

```Java
class Solution {
    public int[] plusOne(int[] digits) {
        // make copy of array
        int[] solutionArr = new int[digits.length];
        for (int j = 0; j < digits.length; j++) {
            solutionArr[j] = digits[j];
        }

        // start from last element in array, increment last item in array
        // while we need to carry a 1:
            // decrement index by 1 and carry until it cannot carry anymore
        for (int i = (digits.length-1); i >= 0; i--) {
            solutionArr[i] = digits[i] + 1;
            if (solutionArr[i] == 10 && i != 0) { // set to 9 and carry
                solutionArr[i] = 0;
            } else if (solutionArr[i] == 10 && i == 0) {
                // increase size of array & make first val 1
                int[] tempDig = new int[(digits.length+1)];

                tempDig[0] = 1;
                tempDig[1] = 0;
                for (int j = 1; j < digits.length; j++) {
                    tempDig[j+1] = solutionArr[j];
                }
                // return larger array
                return tempDig;
            }else {
                return solutionArr;
            }
        }
        return solutionArr;
    }
}
```
