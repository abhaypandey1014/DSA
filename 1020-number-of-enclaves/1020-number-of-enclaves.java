class Solution {
    public void dfs(int grid[][],int i,int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i>=n || j>=m || i<0 || j<0 || grid[i][j]==2 || grid[i][j]==0) return;
        grid[i][j] = 2;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n;i++){
            if(grid[i][0]==1) dfs(grid,i,0);
            if(grid[i][m-1]==1) dfs(grid,i,m-1);
        }
        for(int i = 0;i<m;i++){
            if(grid[0][i]==1) dfs(grid,0,i);
            if(grid[n-1][i]==1) dfs(grid,n-1,i);
        }
        int ans = 0;
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++) if(grid[i][j]==1) ans++;
        }
        return ans;
    }
}