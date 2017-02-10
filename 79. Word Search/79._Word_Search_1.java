public class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0) {
            return false;
        }
        int col = board[0].length;
        if (col == 0) {
            return false;
        }
        boolean[][] used = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ifMatch(board, word, used, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean ifMatch(char[][] board, String word, boolean[][] used, int count, int i, int j) {
        if (count == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || used[i][j] == true || board[i][j] != word.charAt(count)) {
            return false;
        } else {
            used[i][j] = true;
            if (ifMatch(board, word, used, count + 1, i + 1, j) || ifMatch(board, word, used, count + 1, i - 1, j) || ifMatch(board, word, used, count + 1, i, j + 1) || ifMatch(board, word, used, count + 1, i, j - 1)) {
                return true;
            }
            used[i][j] = false;
            return false;
        }
    }
}