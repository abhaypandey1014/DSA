class Solution {
    public int help(int i,int j,int arr[],int dp[][]){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k = i;k<=j;k++){
            int step = arr[i-1]*arr[k]*arr[j+1]+help(i,k-1,arr,dp)+help(k+1,j,arr,dp);
            max = Math.max(max,step);
        }
        return dp[i][j] = max;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length+2;
        int arr[] = new int[n];
        int dp[][] = new int[n+1][n+1];
        for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1);
        arr[0] = 1;
        arr[n-1] = 1;
        for(int i = 0;i<nums.length;i++){
            arr[i+1] = nums[i];
        }
        return help(1,n-2,arr,dp);
    }
}