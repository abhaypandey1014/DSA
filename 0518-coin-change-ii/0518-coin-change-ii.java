class Solution {
    public int help(int amount, int[] coins,int i,int dp[][]){
        if(amount==0) return 1;
        if(i>=coins.length) return 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int pick = 0;
        int skip = 0;
        //valid
        if(amount>=coins[i]) pick = help(amount-coins[i],coins,i,dp);
        skip = help(amount,coins,i+1,dp);
        return dp[i][amount] = pick+skip;
    }
    public int change(int amount, int[] coins) {
        int n =  coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1); 
        return help(amount,coins,0,dp);
    }
}