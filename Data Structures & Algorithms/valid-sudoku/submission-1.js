class Solution {
    /**
     * @param {character[][]} board
     * @return {boolean}
     */
    isValidSudoku(board) {
        for (let r = 0; r < 9; r++) {
            let seen = new Set();
            for (let c = 0; c < 9; c++) {
                if (board[r][c] === ".") continue;
                if (seen.has(board[r][c])) return false;
                seen.add(board[r][c]);
            }
        }
        for (let c = 0; c < 9; c++) {
            let seen = new Set();
            for (let r = 0; r < 9; r++) {
                if (board[r][c] === ".") continue;
                if (seen.has(board[r][c])) return false;
                seen.add(board[r][c]);
            }
        }
        for (let i = 0; i < 9; i++) {
            let seen = new Set();
            for (let row = 0; row < 3; row++) {
                for (let col = 0; col < 3; col++) {
                    let r = Math.floor(i / 3) * 3 + row;
                    let c = (i % 3) * 3 + col;
                    if (board[r][c] === ".") continue;
                    if (seen.has(board[r][c])) return false;
                    seen.add(board[r][c]);
                }
            }
        }
        return true;
    }
}
