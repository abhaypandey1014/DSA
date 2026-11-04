class Solution {
    public int help(int prices[],int i,int buy,int cool,int dp[][][]){
        if(i>=prices.length) return 0;
        int pick = 0;
        int skip = 0;
        if(dp[i][buy][cool]!=-1) return dp[i][buy][cool];
        if(buy==1){
            pick = Math.max(prices[i]+help(prices,i+1,0,1,dp),help(prices,i+1,1,0,dp));
        }
        else{
            if(cool==1) skip = help(prices,i+1,0,0,dp);
            else skip = Math.max(-prices[i]+help(prices,i+1,1,0,dp),help(prices,i+1,0,0,dp));
        }
        return dp[i][buy][cool] = Math.max(pick,skip);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][2];
        // for(int i = 0;i<=n;i++){
        //     for(int j = 0;j<2;j++) Arrays.fill(dp[i][j],-1);
        // }
        // return help(prices,0,0,0,dp);
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<2;j++){
                for(int k = 0;k<2;k++){
                    int pick = 0;
                    int skip = 0;
                    //khareede ni hai
                    if(j==0){
                        //beche hai iske pehle
                        if(k==1) skip = dp[i+1][j][0];
                        else skip = Math.max(-prices[i]+dp[i+1][1][0],dp[i+1][0][0]);
                    }
                    else pick = Math.max(prices[i]+dp[i+1][0][1],dp[i+1][1][0]);
                    dp[i][j][k] = Math.max(pick,skip);
                }
            }
        }
        return dp[0][0][0];
    }
}