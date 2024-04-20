public class Solution79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isExist = exist(board, i, j, word, 0);
                if (isExist) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) {
            return true;
        }

        // 越界
        if (i < 0 || i == board.length) {
            return false;
        }
        if (j < 0 || j == board[0].length) {
            return false;
        }

        // 已访问
        if (board[i][j] == ' ') {
            return false;
        }

        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = ' ';
        boolean isExist = exist(board, i - 1, j, word, k + 1) || exist(board, i + 1, j, word, k + 1) ||
                exist(board, i, j - 1, word, k + 1) || exist(board, i, j + 1, word, k + 1);
        board[i][j] = tmp;
        return isExist;
    }
}
