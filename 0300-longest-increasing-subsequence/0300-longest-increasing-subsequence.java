class Solution {
    // public int help(int arr[],int nums[],int i,int j,int n,int dp[][]){
    //     if(i>=n || j>=n) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(arr[i]==nums[j]) {
    //         if(i-1>=0 && arr[i]==arr[i-1]) return help(arr,nums,i+1,j+1,n,dp);
    //         else return 1+help(arr,nums,i+1,j+1,n,dp);
    //     }
    //     return dp[i][j] = Math.max(help(arr,nums,i+1,j,n,dp),help(arr,nums,i,j+1,n,dp));
    // }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        // for(int i = 0;i<n;i++) arr[i] = nums[i];
        // Arrays.sort(arr);
        // int dp[][] = new int[n][n];
        // for(int i = 0;i<n;i++) Arrays.fill(dp[i],-1);
        // return help(arr,nums,0,0,n,dp);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i = 1;i<n;i++){
            if(nums[i]>ans.get(ans.size()-1)) ans.add(nums[i]);
            else{
                int idx = find(ans,ans.size(),nums[i]);
                ans.set(idx,nums[i]);
            }
        }
        return ans.size();
    }
    public int find(ArrayList<Integer> ans,int len,int tar){
        int lo = 0;
        int hi = len-1;
        while(hi>=lo){
            int mid = lo+(hi-lo)/2;
            if(ans.get(mid)>tar) hi = mid-1;
            else if(ans.get(mid)==tar) return mid;
            else lo = mid+1;
        }
        return lo;
    }
}