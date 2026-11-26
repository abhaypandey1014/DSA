class Solution {
    public int help(int[] coins, int amount,int i,int dp[][]){
        if(i<0||amount<0) return Integer.MAX_VALUE-1;
        if(amount==0) return 0;
       
        //pick
        if(dp[i][amount]!=-1) return dp[i][amount];
        int pick = Integer.MAX_VALUE-1;
        int skip = Integer.MAX_VALUE-1;
        if(coins[i]<=amount){
            pick = 1+help(coins,amount-coins[i],i,dp);
        }
        skip = help(coins,amount,i-1,dp);
        return dp[i][amount] = Math.min(pick,skip);
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1);
        return help(coins,amount,n-1,dp)==Integer.MAX_VALUE-1?-1:help(coins,amount,n-1,dp);
        // for(int i = 1;i<=amount;i++) dp[0][i] = amount+1;
        // for(int i = 1;i<=n;i++){
        //     for(int j = 1;j<=amount;j++){
        //         int val = coins[i-1];
        //         //pick
        //         if(j>=val) dp[i][j] =  Math.min(1+dp[i][j-val],dp[i-1][j]);
        //         else dp[i][j] = dp[i-1][j];
        //     }
        // } 
        // for(int i = 0;i<=n;i++){
        //     for(int j = 0;j<=amount;j++) System.out.print(dp[i][j]+"\t");
        //     System.out.println();
        // }
        // return dp[n][amount]==amount+1?-1:dp[n][amount];
    }
}