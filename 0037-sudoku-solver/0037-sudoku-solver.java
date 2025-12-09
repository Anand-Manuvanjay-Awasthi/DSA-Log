class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char digit='1';digit<='9';digit++){
                         if(canplace(board,row,col,digit)){
                           board[row][col]=digit;
                           if(solve(board)) return true;
                           board[row][col]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean canplace(char[][] board, int row,int col,char digit){
        return (rowcheck(board,row,digit) && colcheck(board,col,digit) && boxcheck(board,row,col,digit));
    }
    //check the row --> horizontal
    public boolean rowcheck(char[][] board,int row,char digit){
        for(int i=0;i<9;i++){
            if(board[row][i] == digit) return false;
        }
        return true;
    }

    //check for col --> vertical
    public boolean colcheck(char[][] board,int col,char digit){
        for(int i=0;i<9;i++){
            if(board[i][col]==digit) return false;
        }
        return true;
    }

    //check for sub-box
    public boolean boxcheck(char[][] board,int row,int col,char digit){
        int boxrow = (row/3)*3;
        int boxcol = (col/3)*3;
        for(int i=boxrow;i<boxrow+3;i++){
            for(int j=boxcol;j<boxcol+3;j++){
                if(board[i][j]== digit) return false;
            }
        }
        return true;
    }
}