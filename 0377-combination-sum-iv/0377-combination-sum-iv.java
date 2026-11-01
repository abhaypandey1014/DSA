class Solution {
    public int help(int nums[],int i,int target,int dp[][]){
        if(i>=nums.length) return target==0?1:0;
        if(target==0) return 1;
        if(dp[i][target]!=-1) return dp[i][target];
        int ans = 0;
        for(int j = 0;j<nums.length;j++){
            if(target-nums[j]>=0) {
                ans += help(nums,j,target-nums[j],dp);
            }
            else break;
        }
        return dp[i][target] = ans;
    }
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[][] = new int[n+1][target+1];
        for(int i = 0;i<n;i++) Arrays.fill(dp[i],-1);
        return help(nums,0,target,dp);
    }
}