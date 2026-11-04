class Solution {
    public int help(int prices[],int i,int buy,int k,int dp[][][]){
        if(i>=prices.length || k==3) return 0;
        if(dp[i][buy][k]!=-1) return dp[i][buy][k];
        int pick = 0;
        int skip = 0;
        if(buy==0) pick = Math.max(-prices[i]+help(prices,i+1,1,k+1,dp),help(prices,i+1,0,k,dp));
        else skip = Math.max(prices[i]+help(prices,i+1,0,k,dp),help(prices,i+1,1,k,dp));
        return dp[i][buy][k] = Math.max(pick,skip);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        for(int i =0;i<=n;i++){
            for(int j = 0;j<2;j++) Arrays.fill(dp[i][j],-1);
        }
        return help(prices,0,0,0,dp);
    }
}