class Solution {
    private static final int SIZE = 9;
    private static final int BLOCK_SIZE = 3;
    private static final char EMPTY = '.';

    private final int[] rows = new int[SIZE];
    private final int[] cols = new int[SIZE];
    private final int[] blocks = new int[SIZE];
    private final int ALL_SET = (1 << SIZE) - 1; 

    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        initBitsets();
        backtrack();
    }

    private void initBitsets() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] != EMPTY) {
                    int val = board[r][c] - '1';
                    int mask = 1 << val;
                    rows[r] |= mask;
                    cols[c] |= mask;
                    blocks[getBlockId(r, c)] |= mask;
                }
            }
        }
    }

    private boolean backtrack() {
        int[] cell = getNextCell();
        if (cell[0] == -1) return true; 

        int r = cell[0], c = cell[1];
        int blockId = getBlockId(r, c);
        int available = ~(rows[r] | cols[c] | blocks[blockId]) & ALL_SET;

        while (available > 0) {
            int bit = available & -available; 
            int digit = Integer.numberOfTrailingZeros(bit);

            placeNumber(r, c, blockId, digit);
            if (backtrack()) return true;
            removeNumber(r, c, blockId, digit);

            available ^= bit; 
        }
        return false;
    }

    private int[] getNextCell() {
        int minCount = 10;
        int[] res = {-1, -1};
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] != EMPTY) continue;
                int count = Integer.bitCount(~(rows[r] | cols[c] | blocks[getBlockId(r, c)]) & ALL_SET);
                if (count < minCount) {
                    minCount = count;
                    res[0] = r;
                    res[1] = c;
                    if (count == 1) return res; 
                }
            }
        }
        return res;
    }

    private void placeNumber(int r, int c, int blockId, int digit) {
        int mask = 1 << digit;
        rows[r] |= mask;
        cols[c] |= mask;
        blocks[blockId] |= mask;
        board[r][c] = (char) ('1' + digit);
    }

    private void removeNumber(int r, int c, int blockId, int digit) {
        int mask = ~(1 << digit);
        rows[r] &= mask;
        cols[c] &= mask;
        blocks[blockId] &= mask;
        board[r][c] = EMPTY;
    }

    private int getBlockId(int r, int c) {
        return (r / BLOCK_SIZE) * BLOCK_SIZE + (c / BLOCK_SIZE);
    }
}
