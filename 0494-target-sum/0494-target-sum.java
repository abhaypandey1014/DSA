class Solution {
    public int help(int nums[],int target,int i,int sum){
        if(i>=nums.length) return sum==target?1:0;
        // if(dp[i][sum+total]!=-1) return dp[i][sum+total];
        int sum1 = 0;
        int sum2= 0;
        sum1 += help(nums,target,i+1,sum+nums[i]);
        sum2 += help(nums,target,i+1,sum-nums[i]);
        return sum1+sum2;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        // for(int i = 0;i<nums.length;i++) sum += nums[i];
        // int dp[][] = new int[nums.length+1][2*sum+1];
        // for(int i = 0;i<=nums.length;i++) Arrays.fill(dp[i],-1);
        return help(nums,target,0,0);
    }
}