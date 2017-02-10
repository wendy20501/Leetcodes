public class Solution {
    public int numIslands(char[][] grid) {
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int width = grid[0].length;
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    searchAll(grid, height, width, i, j, count);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void searchAll(char[][] grid, int height, int width, int i, int j, int count) {
        grid[i][j] = (char)('a' + count);
        //System.out.println("grid[" + i + "][" + j + "] = " + count);
        if (i > 0 && grid[i - 1][j] == '1') {
            searchAll(grid, height, width, i - 1, j, count);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            searchAll(grid, height, width, i, j - 1, count);
        }
        if (i < height - 1 && grid[i + 1][j] == '1') {
            searchAll(grid, height, width, i + 1, j, count);
        }
        if (j < width - 1 && grid[i][j + 1] == '1') {
            searchAll(grid, height, width, i, j + 1, count);
        }
    }
}