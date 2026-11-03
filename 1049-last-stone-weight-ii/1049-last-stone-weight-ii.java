class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int n = stones.length;
        for(int i = 0;i<n;i++) sum += stones[i];
        // int dp[][] = new int[n+1][(sum/2)+1];
        int dp[] = new int[(sum/2)+1];
        for(int i = 1;i<n+1;i++){
            for(int j = dp.length-1;j>=1;j--){
                int pick = 0;
                int skip = 0;
                if(stones[i-1]<=j){
                    pick = Math.max(stones[i-1]+dp[j-stones[i-1]],dp[j]);
                }
                skip = dp[j];
                dp[j] = Math.max(pick,skip);
            }
        }
        return sum-2*dp[(sum/2)];
    }
}