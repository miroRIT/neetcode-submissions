class Solution {
    /**
     * @param {character[][]} board
     * @return {boolean}
     */
    isValidSudoku(board: string[][]): boolean {
        for (let r: number = 0; r < 9; r++) {
            let seen: Set<string> = new Set();
            for (let c: number = 0; c < 9; c++) {
                if (board[r][c] === ".") continue;
                if (seen.has(board[r][c])) return false;
                seen.add(board[r][c]);
            }
        }
        for (let c: number = 0; c < 9; c++) {
            let seen: Set<string> = new Set();
            for (let r: number = 0; r < 9; r++) {
                if (board[r][c] === ".") continue;
                if (seen.has(board[r][c])) return false;
                seen.add(board[r][c]);
            }
        }
        for (let i: number = 0; i < 9; i++) {
            let seen: Set<string> = new Set();
            for (let row: number = 0; row < 3; row++) {
                for (let col: number = 0; col < 3; col++) {
                    let r: number = Math.floor(i / 3) * 3 + row;
                    let c: number = (i % 3) * 3 + col;
                    if (board[r][c] === ".") continue;
                    if (seen.has(board[r][c])) return false;
                    seen.add(board[r][c]);
                }
            }
        }
        return true;
    }
}
