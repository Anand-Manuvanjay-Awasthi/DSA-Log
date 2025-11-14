class Solution {
    public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];

            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    visited[i][j]=false;
                }
            }
           for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if(existhelp(board,word,"",i,j,visited)) return true;
                }
            }
        }
        return false;
    }
    private boolean existhelp(char[][] board, String word,String ans,int i ,int j,boolean[][] visited){
        if(ans.length()==word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(ans.length())) return false;
        if(visited[i][j]) return false;
        visited[i][j] = true;
        if(existhelp(board,word,ans+board[i][j],i,j-1,visited) || existhelp(board,word,ans+board[i][j],i,j+1,visited)
        ||existhelp(board,word,ans+board[i][j],i+1,j,visited)||existhelp(board,word,ans+board[i][j],i-1,j,visited)) return true;

        visited[i][j] = false;
        return false;
    }
}