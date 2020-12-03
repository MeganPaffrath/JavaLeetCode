# 200. Number of Islands

[Return](../README.md)

Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Ex1

```
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```

Ex2:

```
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
```

# Test Cases

```
[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]


[["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]

[["1","0","1","1","1"],["1","0","1","0","1"],["1","1","1","0","1"]]

[["0","1","1","0","1"],["0","0","0","0","1"],["1","1","0","1","1"],["0","1","0","1","0"]]
```

# Solution

```Java
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        // initialize island count
        int islands = 0;

        // initialize test grid
        char[][] testGrid = new char[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                testGrid[i][j] = ' ';
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (testGrid[i][j] == ' ') {
                    // try to fill
                    if (grid[i][j] == '0') {
                        testGrid[i][j] = '0';
                    } else {
                        islands++;
                        testGrid = gridFiller(i, j, grid, testGrid);
                    }
                    // System.out.println("For " + islands + ", grid is now:");
                    // showGrid(testGrid);
                }
            }
        }

        return islands;
    }

    public char[][] gridFiller(int i, int j, char[][] input, char[][] testGrid) {
        if (testGrid[i][j] != ' ') {
            return testGrid;
        }
        testGrid[i][j] = '1';

        // Fill surrounding items, recursively if 1
        // right item
        if ( j < (input[0].length - 1) ) {
            if (input[i][j+1] == '1') {
                testGrid = gridFiller(i, (j+1), input, testGrid);
            } else {
                testGrid[i][j+1] = '0';
            }
        }

        // item left
        if ( j > 0 ) {
            if (input[i][j-1] == '1') {
                testGrid = gridFiller(i, (j-1), input, testGrid);
            } else {
                testGrid[i][j-1] = '0';
            }
        }

        // item below
        if (i < (input.length - 1) ) {
            if (input[i+1][j] == '1') {
                testGrid = gridFiller((i+1), j, input, testGrid);
            } else {
                testGrid[i+1][j] = '0';
            }
        }

        // item above
        if (i > 0 ) {
            if (input[i-1][j] == '1') {
                testGrid = gridFiller((i-1), j, input, testGrid);
            } else {
                testGrid[i-1][j] = '0';
            }
        }

        return testGrid;
    }

    public void showGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```
