class Solution {
    public int lcs(int[] nums,int[] nums2){
        int n = nums.length;
        int m = nums2.length;
        int[] dp = new int[nums2.length+1];
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(nums[i-1]==nums2[j-1])//equal
                {
                    dp[j] = 1 + dp[j-1];
                }
                else 
                {
                    int ans1 = dp[j];
                    int ans2 = dp[j-1];
                    dp[j] = Math.max(ans1,ans2);
                }
            }
        }
        return dp[m];
    }
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int nums2[] = new int[set.size()];
        int k = 0;
        for(int num : set){
            nums2[k] = num;
            k++;
        }
        Arrays.sort(nums2);
        //longest common subsequence
        return lcs(nums,nums2);
    }
}