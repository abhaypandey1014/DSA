class Solution {
    public int help(int[][] dp,int nums[],int target,int idx,int sum,int total){
        if(idx == nums.length){
        return sum == target?1:0;
        }
        if(dp[idx][sum+total]!=-1) return dp[idx][sum+total];
        int add = help(dp,nums,target,idx+1,sum+nums[idx],total);
        int sub = help(dp,nums,target,idx+1,sum-nums[idx],total);
        return dp[idx][sum+total] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int i = 0;i<nums.length;i++) total+=nums[i];
        int dp[][] = new int[n+1][2*total+1];
        for(int i = 0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return help(dp,nums,target,0,0,total);
        // return dp[n][target];
    }
}