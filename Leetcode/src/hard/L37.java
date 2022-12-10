package hard;

public class L37 {
    private boolean[][] horizontalCheck = new boolean[9][9];
    private boolean[][] vertialCheck = new boolean[9][9];
    private boolean[][] cellCheck = new boolean[9][9];
    private boolean end=false;

    public void solveSudoku(char[][] board) {
        // load board data to checks
        init(board);
        // solve from the first number
        solvepart(board, 0);
    }

    private void init(char[][] board) {
        // for each pos in board
        for (int i = 0; i < 81; i++) {
            // find the horizontal number, vertical number, and cell number
            int x = i / 9;
            int y = i % 9;
            int c = x / 3 * 3 + y / 3;
            // if the cell is unfilled, skip.
            if (board[x][y] == 46) {
                continue;
            }
            // or mark the cell with value.
            mark(x, y, c, board[x][y] - 49, true);
        }
    }

    // mark the cell with given value
    private void mark(int x, int y, int c, int value, boolean state) {
        horizontalCheck[x][value] = state;
        vertialCheck[y][value] = state;
        cellCheck[c][value] = state;
    }

    // recursive solve based on possible solutions
    private void solvepart(char[][] board, int pos) {
        // if the search ends
        if (pos >= 81) {
            end=true;
            return;
        }
        // else, init search
        int x = pos / 9;
        int y = pos % 9;
        int c = x / 3 * 3 + y / 3;
        // if the cell is filled, skip
        if (board[x][y] != 46) {
            solvepart(board, pos + 1);
            
        } else {
            // find possible number based on x, y, c
            boolean[] possibleNum = findNums(x, y, c);
            // for each possible number, test it with fill.
            for (int i = 0; i < 9; i++) {
                if (!possibleNum[i]) {
                    // test if the case satisfy
                    mark(x, y, c, i, true);
                    board[x][y] = (char) ('1' + i);
                    solvepart(board, pos + 1);
                    if(end){
                        return;
                    }
                    // if failed restore value
                    board[x][y] = '.';
                    mark(x, y, c, i, false);
                }
            }
        }
    }

    private boolean[] findNums(int horizontal, int vertical, int cell) {
        boolean[] result = new boolean[9];
        for (int i = 0; i < 9; i++) {
            result[i] = horizontalCheck[horizontal][i] || vertialCheck[vertical][i] || cellCheck[cell][i];
        }
        return result;
    }

    public static void main(String[] args) {
        L37 a = new L37();
        char[][] sudo = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        a.solveSudoku(sudo);
        a.printarray(sudo);
    }

    private void printarray(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
