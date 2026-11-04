class Solution {
    public int help(char matrix[][],int i,int j,int max[],int dp[][]){
        if(i>=matrix.length||j>=matrix[0].length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int left = help(matrix,i,j+1,max,dp);
        int right = help(matrix,i+1,j,max,dp);
        int dia = help(matrix,i+1,j+1,max,dp);
        if(matrix[i][j]=='1') {
            int ans = 1+Math.min(right,Math.min(dia,left));
            max[0] = Math.max(ans,max[0]);
            return dp[i][j] = ans;
        }
        else return dp[i][j] = 0;
    }
    public int maximalSquare(char[][] matrix) {
        int max[] = {0};
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n+1][m+1];
        for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1);
        help(matrix,0,0,max,dp);
        return max[0]*max[0];
    }
}