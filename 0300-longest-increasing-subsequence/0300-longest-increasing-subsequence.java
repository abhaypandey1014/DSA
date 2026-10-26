class Solution {
    public int help(int arr[],int nums[],int i,int j,int n,int dp[][]){
        if(i>=n || j>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(arr[i]==nums[j]) {
            if(i-1>=0 && arr[i]==arr[i-1]) return help(arr,nums,i+1,j+1,n,dp);
            else return 1+help(arr,nums,i+1,j+1,n,dp);
        }
        return dp[i][j] = Math.max(help(arr,nums,i+1,j,n,dp),help(arr,nums,i,j+1,n,dp));
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        for(int i = 0;i<n;i++) arr[i] = nums[i];
        Arrays.sort(arr);
        int dp[][] = new int[n][n];
        for(int i = 0;i<n;i++) Arrays.fill(dp[i],-1);
        return help(arr,nums,0,0,n,dp);
    }
}