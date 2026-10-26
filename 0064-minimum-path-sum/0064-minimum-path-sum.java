class Solution {
    int min = Integer.MAX_VALUE;
    public int help(int grid[][],int i,int j,int n,int m,int dp[][]){
        if(i>=n || j>=m || grid[i][j]==-1) return Integer.MAX_VALUE;
        if(i==n-1 && j==m-1) return grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int temp = grid[i][j];
        grid[i][j] = -1;
        int way1 = 0;
        int way2 = 0;
        way1 = help(grid,i+1,j,n,m,dp);
        way2 = help(grid,i,j+1,n,m,dp);
        grid[i][j] = temp;
        return dp[i][j] = grid[i][j]+Math.min(way1,way2);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int i = 0;i<n;i++) Arrays.fill(dp[i],-1);
        return help(grid,0,0,grid.length,grid[0].length,dp);
    }
}