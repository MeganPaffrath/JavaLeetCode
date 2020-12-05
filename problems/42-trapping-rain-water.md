# 42. Trapping Rain Water

[Return](../README.md)

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

```
4        _
3    _   |_ _
2  _ |+++||+|
1 _|+||+|||||_

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
```

```
Input: height = [4,2,0,3,2,5]
Output: 9
```

# Solution

```Java
class Solution {
    public int trap(int[] height) {
        // check if there even can be water
        if (height.length < 3) {
            return 0;
        }

        // initialize water
        int water = 0;

        // iterate through array
        for (int i = 1; i < (height.length-1); i++) {
            // if taller than or equal to prev location, continue
            if (height[i] >= height[i-1]) {
                continue;
            }

            // set left wall
            int leftWallHeight = height[i-1];
            int rightWallHeight = -1;

            // find highest following wall location
            int boundLoc = -1;

            for (int j = i+1; j < height.length; j++) {
                // update if new height found
                if (height[j] > rightWallHeight) {
                    rightWallHeight = height[j];
                    boundLoc = j;
                    // rightWallFound = true;
                }
                // stop loop if above or at left wall height
                if (rightWallHeight >= leftWallHeight) {
                    break;
                }
            }

            // fill water between and increment i to the wall's location
            if (rightWallHeight > height[i]) {
                System.out.println("RWH: " + rightWallHeight);
                int waterHeight = Integer.min(leftWallHeight, rightWallHeight);
                System.out.println("Water height: " + waterHeight);

                // fill between bounds
                for (int k = i; k < boundLoc; k++) {
                    System.out.println("K: " + k);
                    water += (waterHeight - height[k]);
                }

                i = boundLoc;
            }
        }


        return water;
    }
}
```

# Test Cases

```
[0,1,0,2,1,0,1,3,2,1,2,1]
[5,4,1,2]
```
