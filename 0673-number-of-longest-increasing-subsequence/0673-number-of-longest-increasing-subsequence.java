class Solution {
    // public void help(int dp[][],ArrayList<ArrayList<Integer>> path,ArrayList<Integer> list,int i,int j,int nums[],int nums2[]){
    //     if(i<=0 || j<=0){
    //         path.add(new ArrayList<>(list));
    //         return;
    //     }
    //     if(nums[i-1]==nums2[j-1]){
    //         list.add(nums[i-1]);
    //         help(dp,path,list,i-1,j-1,nums,nums2);
    //         list.remove(list.size()-1);
    //     }
    //     else{
    //         if(dp[i][j-1]==dp[i][j]) help(dp,path,list,i,j-1,nums,nums2);
    //         if(dp[i-1][j]==dp[i][j]) help(dp,path,list,i-1,j,nums,nums2);
    //     }
    // }
    // public int lcs(int[] nums,int[] nums2){
    //     int n = nums.length;
    //     int m = nums2.length;
    //     int[][] dp = new int[nums.length+1][nums2.length+1];
    //     for(int i = 1;i<n+1;i++){
    //         for(int j = 1;j<m+1;j++){
    //             if(nums[i-1]==nums2[j-1]) dp[i][j] = 1+dp[i-1][j-1];
    //             else{
    //                 int ans1 = dp[i-1][j];
    //                 int ans2 = dp[i][j-1];
    //                 dp[i][j] = Math.max(ans1,ans2);
    //             }
    //         }
    //     }
    //     ArrayList<ArrayList<Integer>> path = new ArrayList<>();
    //     ArrayList<Integer> list = new ArrayList<>();
    //     help(dp,path,list,n,m,nums,nums2);
    //     return path.size();
    // }
    public int findNumberOfLIS(int[] nums) {
        // HashSet<Integer> set = new HashSet<>();
        // for(int i = 0;i<nums.length;i++){
        //     set.add(nums[i]);
        // }
        // int nums2[] = new int[set.size()];
        // int k = 0;
        // for(int num : set){
        //     nums2[k] = num;
        //     k++;
        // }
        // Arrays.sort(nums2);
        // return lcs(nums,nums2);
        int n = nums.length;
        int dp[] = new int[n];
        int cnt[] = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int max = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[i]<dp[j]+1){
                        dp[i] = dp[j]+1;
                        cnt[i] = cnt[j];
                    }
                    else if(dp[i]==dp[j]+1) cnt[i] += cnt[j];
                }
            }
            max = Math.max(dp[i],max);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(dp[i]==max) ans += cnt[i];
        }
        return ans;
    }
}