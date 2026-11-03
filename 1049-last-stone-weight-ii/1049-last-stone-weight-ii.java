class Solution {
    public int help(int stones[],int i,int sum,int dp[][]){
        if(i>=stones.length) return 0;
        int pick = 0;
        int skip = 0;
        if(dp[i][sum]!=-1) return dp[i][sum];
        if(stones[i]<=sum) pick = Math.max(stones[i]+help(stones,i+1,sum-stones[i],dp),help(stones,i+1,sum,dp));
        skip = help(stones,i+1,sum,dp);
        return dp[i][sum] = Math.max(pick,skip);
    }
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int n = stones.length;
        for(int i = 0;i<n;i++) sum += stones[i];
        // int dp[][] = new int[n+1][(sum/2)+1];
        int dp[][] = new int[n+1][(sum/2)+1];
        for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1);
        // for(int i = 1;i<n+1;i++){
        //     for(int j = dp.length-1;j>=1;j--){
        //         int pick = 0;
        //         int skip = 0;
        //         if(stones[i-1]<=j){
        //             pick = Math.max(stones[i-1]+dp[j-stones[i-1]],dp[j]);
        //         }
        //         skip = dp[j];
        //         dp[j] = Math.max(pick,skip);
        //     }
        // }
        // 
        return sum -2*help(stones,0,sum/2,dp);
    }
}