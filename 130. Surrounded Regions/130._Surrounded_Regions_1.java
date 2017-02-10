public class Solution {
    public void solve(char[][] board) {
        int height = board.length;
        if (height == 0) {
            return;
        }
        int width = board[0].length;
        if (height < 3 || width < 3) {
            return;
        }
        for (int i = 0; i < height; i++) {
            if (board[i][0] == 'O') {
                DFS(board, i, 0);
            }
        }
        for (int i = 0; i < height; i++) {
            if (board[i][width - 1] == 'O') {
                DFS(board, i, width - 1);
            }
        }
        for (int j = 0; j < width; j++) {
            if (board[0][j] == 'O') {
                DFS(board, 0, j);
            }
        }
        for (int j = 0; j < width; j++) {
            if (board[height - 1][j] == 'O') {
                DFS(board, height - 1, j);
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void DFS(char[][] board, int i, int j) {
        board[i][j] = 'A';
        if (i + 1 < board.length && board[i + 1][j] == 'O') {
            DFS(board, i + 1, j);
        }
        if (i - 1 > 0 && board[i - 1][j] == 'O') {
            DFS(board, i - 1, j);
        }
        if (j + 1 < board[0].length && board[i][j + 1] == 'O') {
            DFS(board, i, j + 1);
        }
        if (j - 1 > 0 && board[i][j - 1] == 'O') {
            DFS(board, i, j - 1);
        }
    }
}