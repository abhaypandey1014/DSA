class Solution {
    public int solve(int nums[],HashMap<Integer,Integer> dp[],int i,int diff){
        if(i<0) return 0;
        int ans = 0;
        if(dp[i].containsKey(diff)) return dp[i].get(diff);
        for(int j = i-1;j>=0;j--){
            if(nums[i]-nums[j]==diff) ans = Math.max(ans,1+solve(nums,dp,j,diff));
        }
        dp[i].put(diff,ans);
        return ans;
    }
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if(n<=2) return n;
        HashMap<Integer,Integer> dp[] = new HashMap[n];
        int max = 0;
        for(int i = 0;i<n;i++) dp[i] = new HashMap<>();
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                int diff = nums[i]-nums[j];
                max = Math.max(max,2+solve(nums,dp,j,diff));
            }
        }
        // for(int i = 1;i<n;i++){
        //     for(int j = 0;j<i;j++){
        //         int diff = nums[i]-nums[j];
        //         int len = dp[j].getOrDefault(diff,1)+1;
        //         dp[i].put(diff,len);
        //         max = Math.max(len,max);
        //     }
        // }
        return max;
    }
}