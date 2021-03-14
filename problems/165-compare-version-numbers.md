# 165 Compare Version Numbers

[Return](../README.md)

# Instructions
Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.
 
```
Example 1:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
```

```
Example 2:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".
```

```
Example 3:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
```
```
Example 4:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
```
```
Example 5:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
```

# Code
## Better Solution
- Space: O(N)
- Time: O(N)
```Java
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int max = Integer.max(v1.length, v2.length);
        
        int n1, n2;
        for (int i = 0; i < max; i++) {
            n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (n1 != n2) {
                return n1 < n2 ? -1 : 1;
            }
        }
        
        return 0;     
    }
}
```

## Original solution
- Space: O(N)
- Time: O(N)
- A lot of code, could be cleanner...
```Java
class Solution {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> v1 = new ArrayList<Integer>();
        ArrayList<Integer> v2 = new ArrayList<Integer>();
        v1.add(0);
        v2.add(0);
        
        // ver1
        for (int i=0; i < version1.length(); i++) {
            if (version1.charAt(i) == '.') {
                v1.add(0);
            } else {
                Integer val = v1.get(v1.size() -1);
                Integer currInt = Character.getNumericValue(version1.charAt(i));
                v1.set(v1.size() - 1, val * 10 + currInt);
            }
        }
        
        // ver2
        for (int i=0; i < version2.length(); i++) {
            if (version2.charAt(i) == '.') {
                v2.add(0);
            } else {
                Integer val = v2.get(v2.size() -1);
                Integer currInt = Character.getNumericValue(version2.charAt(i));
                v2.set(v2.size() - 1, val * 10 + currInt);
            }
        }
        
        
        
        // If version1 < version2, return -1.
        // If version1 > version2, return 1.
        // Otherwise, return 0.
        int maxSize = Integer.max(v1.size(), v2.size());
        
        for (int i=0; i < maxSize; i++) {
            int item1 = 0;
            int item2 = 0;
            
            if (v1.size() > i) {
                item1 = v1.get(i);
            }
            if (v2.size() > i) {
                item2 = v2.get(i);
            }
            
            if (item1 < item2) {
                return -1;
            } else if (item1 > item2) {
                return 1;
            }
        }
        
        return 0; // same
    }
}
```