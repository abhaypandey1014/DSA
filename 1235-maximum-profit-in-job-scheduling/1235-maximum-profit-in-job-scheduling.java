class Solution {
    public int find(int lo,int end,int arr[][],int n){
        int hi = n-1;
        int res = n+1;
        while(hi>=lo){
            int mid = lo+(hi-lo)/2;
            if(arr[mid][0]>=end){
                res = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return res;
    }
    public int help(int i,int n,int arr[][],int dp[]){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int idx = find(i+1,arr[i][1],arr,n);
        int pick = arr[i][2]+help(idx,n,arr,dp);
        int skip = help(i+1,n,arr,dp);
        return dp[i] = Math.max(pick,skip);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int arr[][] = new int[n][3];
        for(int i = 0;i<n;i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        Arrays.sort(arr,Comparator.comparingDouble(o->o[0]));
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return help(0,n,arr,dp);
    }
}