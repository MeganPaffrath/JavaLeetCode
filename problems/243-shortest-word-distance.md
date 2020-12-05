# 243. Shortest Word Distance

[Return](../README.md)

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

```
Input: word1 = “coding”, word2 = “practice”
Output: 3
```

```
Input: word1 = "makes", word2 = "coding"
Output: 1
```

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

# Best Solution

```Java
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int distMin = words.length;
        int loc1 = -1, loc2 = -1;

        for (int i = 0; i < words.length; i++) {
            // set word locations if found
            if (words[i].equals(word1)) {
                loc1 = i;
            } else if (words[i].equals(word2)) {
                loc2 = i;
            }

            // calc min
            if (loc1 != -1 && loc2 != -1) {
                distMin = Math.min(distMin, Math.abs(loc1 - loc2));
            }
        }

        return distMin;
    }
}
```

# Silly Solution

```Java
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {

            if (words[i].equals(word1)) { // try for first word
                // count until next word
                for (int j= (i+1); j < words.length; j++) {
                    if (words[j].equals(word2) && shortest > (j-i)) {
                        shortest = j - i;
                    }
                }
            } else if (words[i].equals(word2)) { // else, try for second word
                // count until next word
                for (int j= (i+1); j < words.length; j++) {
                    if (words[j].equals(word1) && shortest > (j-i)) {
                        shortest = j - i;
                    }
                }
            }
        }

        if (shortest != Integer.MAX_VALUE) {
            return shortest;
        } else {
            return -1;
        }

    }
}
```
