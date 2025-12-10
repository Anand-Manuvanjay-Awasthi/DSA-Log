class Solution {
    public int totalNQueens(int n) {
         char [][] board = new char[n][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        queen(res,0,board);
       return res.size(); 
    }
    public void queen(List<List<String>> res , int row , char[][] board){
        if(row==board.length){
            res.add(construct(board));
            return;
        }

        for(int col =0;col<board.length;col++){
            if(isValid(row,col,board)){
                board[row][col] = 'Q';
                queen(res,row+1,board);
                board[row][col]='.';
            }
        }
    }

    public List<String> construct(char[][] board){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String row = new String(board[i]);
            ans.add(row);
        }
        return ans;
    }
    public boolean isValid(int row ,int col,char[][] board){
        //row ke liye 
        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q') return false;
        }
        //left diagonal
        int maxLeft = Math.min(row,col);
        for(int i=0;i<=maxLeft;i++){
            if(board[row-i][col-i]=='Q') return false;
        }
        //right diagonal
        int maxRight = Math.min(row,board.length-1-col);
        for(int i=0;i<=maxRight;i++){
            if(board[row-i][col+i]=='Q') return false;
        }
        return true;
    }
}