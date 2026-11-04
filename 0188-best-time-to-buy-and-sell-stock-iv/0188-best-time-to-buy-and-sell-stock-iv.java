class Solution {
    public int maxProfit(int m, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][m+1];
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<2;j++){
                for(int k = m;k>=0;k--){
                    int pick = 0;
                    int skip = 0;
                    if(j==0) {
                        if(k<m) pick = Math.max(-prices[i]+dp[i+1][1][k+1],dp[i+1][0][k]);
                    }
                    else skip =  Math.max(prices[i]+dp[i+1][0][k],dp[i+1][1][k]);
                    dp[i][j][k] = Math.max(pick,skip);
                }
            }
        }
        return dp[0][0][0];
    }
}