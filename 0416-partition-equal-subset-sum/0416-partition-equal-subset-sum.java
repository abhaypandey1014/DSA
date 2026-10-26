class Solution {
    public boolean help(int nums[],int i,int sum,int dp[][]){
        if(sum==0) return true;
        if(i==nums.length || sum<0) return false;
        if(dp[i][sum]!=-1) return dp[i][sum]==1;
        dp[i][sum] = help(nums,i+1,sum-nums[i],dp)||help(nums,i+1,sum,dp)?1:0;
        return help(nums,i+1,sum-nums[i],dp)||help(nums,i+1,sum,dp);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++) sum += nums[i];
        Arrays.sort(nums);
        if(sum%2!=0) return false;
        int dp[][] = new int[nums.length+1][(sum/2)+1];
        for(int i = 0;i<=nums.length;i++) Arrays.fill(dp[i],-1);
        return help(nums,0,sum/2,dp);
    }
}