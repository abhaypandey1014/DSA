class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        int pref[] = new int[n];
        pref[0] = nums[0];
        for(int i = 1;i<n;i++){
            pref[i] = Math.max(pref[i-1],nums[i]);
        }
        for(int j = k;j<n;j++){
           max = Math.max(max,(long)(pref[j-k]+nums[j]));
        }
        return (int)max;
    }
}