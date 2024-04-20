public class Solution200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void DFS(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length) {
            return;
        }
        if (j < 0 || j == grid[0].length) {
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';
        DFS(grid, i - 1, j);
        DFS(grid, i + 1, j);
        DFS(grid, i, j - 1);
        DFS(grid, i, j + 1);
    }
}
