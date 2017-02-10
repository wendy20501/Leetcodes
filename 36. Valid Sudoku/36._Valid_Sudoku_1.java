public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int boardSize = 9;
        int[] validNum;
        int blockNum = -1;
        char[][] block = new char[boardSize][boardSize];
        char[][] col = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            if (!isValidLine(board[i])) {
                return false;
            }
            for (int j = 0; j < boardSize; j++) {
                if (j % 3 == 0) {
                    blockNum += 1;
                    if (i % 3 == 0) {
                        block[blockNum] = new char[boardSize];
                    }
                }
                //System.out.println("i = " + i + " j = " + j + " blockNum = " + blockNum);
                block[blockNum][(i % 3) * 3 + j % 3] = board[i][j];
                //System.out.println("block["+blockNum+"]["+ ((i % 3) * 3 + j % 3)+"] = " + board[i][j]);
                if (i == 0) {
                    col[j] = new char[boardSize];
                }
                col[j][i] = board[i][j];
            }

            if ((i + 1) % 3 == 0) {
                if (!isValidLine(block[blockNum - 2]) || !isValidLine(block[blockNum - 1]) || !isValidLine(block[blockNum])) {
                    return false;
                }
            } else {
                blockNum -= 3;
            }
        }
        for (int k = 0; k < boardSize; k++) {
            if (!isValidLine(col[k])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidLine(char[] line) {
        //System.out.println("check");
        int boardSize = 9;
        int[] validNum = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int j = 0; j < boardSize; j++) {
            //System.out.println(line[j]);
            if (line[j] != '.') {
                int current = Character.getNumericValue(line[j]);
                if (current < 1 || current > 9) {
                    return false;
                } else if (validNum[current - 1] == 1) {
                    return false;
                } else {
                    validNum[current - 1] = 1;
                }
            }
        }
        return true;
    }
}