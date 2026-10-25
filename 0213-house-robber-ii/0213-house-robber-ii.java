class Solution {
    // public int help(int i,int n,int dp[],int nums[]){
    //     if(i>=n) return 
    // }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        if(n==1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        int dp1[] = new int[n];
        dp1[1] = nums[1];
        dp1[0] = 0;
        for(int i = 2;i<n;i++){
            dp1[i] = Math.max(nums[i]+dp1[i-2],dp1[i-1]);
        }
        for(int i = 2;i<n-1;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return Math.max(dp1[n-1],dp[n-2]);
        
    }
}