class Solution {
    public int help(int grid[][],int i,int j,int n,int m,int xor,int dp[][][]){
        if(i>=n || j>=m || grid[i][j]==-1) return Integer.MAX_VALUE;
        if(dp[i][j][xor]!=-1) return dp[i][j][xor];
        int temp = grid[i][j];
        if(i==n-1 && j==m-1) return xor^grid[i][j];
        grid[i][j] = -1;
        int way1 = help(grid,i+1,j,n,m,xor^temp,dp);
        int way2 = help(grid,i,j+1,n,m,xor^temp,dp);
        grid[i][j] = temp;
        return dp[i][j][xor] = Math.min(way1,way2);
    }
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n+1][m+1][1024];
        for(int i = 0;i<=n;i++) {
            for(int j = 0;j<=m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return help(grid,0,0,n,m,0,dp);
    }
}