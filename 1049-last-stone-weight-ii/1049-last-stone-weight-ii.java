class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int n = stones.length;
        for(int i = 0;i<n;i++) sum += stones[i];
        int dp[][] = new int[n+1][(sum/2)+1];
        // for(int i = 0;i<dp[0].length;i++){
        //     dp[0][i] = 
        // }
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<dp[0].length;j++){
                int pick = 0;
                int skip = 0;
                if(stones[i-1]<=j){
                    pick = Math.max(stones[i-1]+dp[i-1][j-stones[i-1]],dp[i-1][j]);
                }else skip = dp[i-1][j];
                dp[i][j] = Math.max(pick,skip);
            }
        }
        return sum-2*dp[n][(sum/2)];
    }
}