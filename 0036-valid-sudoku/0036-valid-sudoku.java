class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    int num = board[i][j]-'1';
                    int boxi = (i/3)*3 +(j/3);
                    if(row[i][num] || col[j][num] || boxes[boxi][num]) return false;

                    row[i][num]=col[j][num]=boxes[boxi][num]=true;
                }
            }
        }
        return true;
    }
}