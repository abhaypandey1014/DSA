class Solution {
    // public int help(int[] coins, int amount,int i,int dp[][]){
    //     if(amount==0) return 0;
    //     if(i<0) return Integer.MAX_VALUE;
    //     //pick
    //     if(dp[i][amount]!=-1) return dp[i][amount];
    //     int pick = Integer.MAX_VALUE;
    //     int skip = Integer.MAX_VALUE;
    //     if(coins[i]<=amount){
    //         pick = help(coins,amount-coins[i],i,dp);
    //         if(pick!=Integer.MAX_VALUE) pick += 1;
    //     }
    //     skip = help(coins,amount,i-1,dp);
    //     return dp[i][amount] = Math.min(pick,skip);
    // }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        // for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1);
        // return help(coins,amount,n-1,dp)==Integer.MAX_VALUE?-1:help(coins,amount,n-1,dp);
        for(int i = 1;i<=amount;i++) dp[0][i] = Integer.MAX_VALUE-1;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=amount;j++){
                int val = coins[i-1];
                //pick
                if(j>=val) dp[i][j] =  Math.min(1+dp[i][j-val],dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        } 
        return dp[n][amount]==Integer.MAX_VALUE-1?-1:dp[n][amount];
    }
}