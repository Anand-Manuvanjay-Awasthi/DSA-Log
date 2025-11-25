class Solution {
    public int uniquePathsIII(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                visited[i][j]=false;
            }
        }

        int empty = 0;
        int startI=0;
        int startJ=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] != -1) empty++;           
                if(grid[i][j]==1){
                   startI=i;
                   startJ=j;
                }
            }
        }
        return backtrack(grid, visited, startI, startJ, empty);
    }

   
    private int backtrack(int[][] grid, boolean[][] visited, int i, int j, int remaining){
      
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j]==-1) return 0;
        if(grid[i][j]==2) {
            if(remaining==1) return 1;
            else return 0;
        }
        visited[i][j]=true;
        int paths = 0;
        paths += backtrack(grid, visited, i+1, j, remaining-1);
        paths += backtrack(grid, visited, i, j+1, remaining-1);
        paths += backtrack(grid, visited, i-1, j, remaining-1);
        paths += backtrack(grid, visited, i, j-1, remaining-1);
        visited[i][j]=false;
        return paths;
    }
}
