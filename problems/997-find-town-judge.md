# 977 Find the Town Judge

[Return](../README.md)

# Problem

In a town, there are N people labelled from 1 to N. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge. Otherwise, return -1.

Example 1:

```
Input: N = 2, trust = [[1,2]]
Output: 2
```

Example 2:

```
Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
```

Example 3:

```
Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
```

Example 4:

```
Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
```

Example 5:

```
Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3

```

Constraints:

```

1 <= N <= 1000
0 <= trust.length <= 10^4
trust[i].length == 2
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N

```

# Good Solution

```Java
class Solution {
    public int findJudge(int N, int[][] trust) {
        if (N == 1) return 1;

        // Keep track of if each person is trusted and if they trust
        int[] trusted = new int[N+1];
        int[] trusts = new int[N+1];


        for (int[] trustRel : trust) {
            trusted[trustRel[1]]++;
            trusts[trustRel[0]]++;
        }

        // find the judge
        for (int i = 0; i < trusts.length; i++) {
            if (trusted[i] == (N-1) && trusts[i] == 0) {
                return i;
            }
        }

        // otherwise there is no judge
        return -1;
    }
}
```

# Pointless Solution

- Inefficient HashMap just to use a hashmap

```Java
class Solution {
    public int findJudge(int N, int[][] trust) {
        // initialize map, store count of how many trust this person
        HashMap<Integer, Integer> trusted = new HashMap<Integer, Integer>();
        HashMap<Integer, Boolean> trusts = new HashMap<Integer, Boolean>();

        // only one person? must be judge
        if (N == 1) return 1;

        // keep track of how many people trust each person
        for (int i = 0; i < trust.length; i++) {
            if (trusted.containsKey(trust[i][1])) {
                trusted.put(trust[i][1], (trusted.get(trust[i][1]) + 1));
            } else {
                trusted.put(trust[i][1], 1);
            }

            trusts.put(trust[i][0], true);
        }

        int judge = -1;

        // find the town judge
        for (Integer key : trusted.keySet()) {
            if (trusted.get(key) == (N-1) && !trusts.containsKey(key)) {
                if (judge != -1) {
                    return -1;
                } else {
                    judge = key;
                }
            }
        }

        return judge;
    }
}
```
