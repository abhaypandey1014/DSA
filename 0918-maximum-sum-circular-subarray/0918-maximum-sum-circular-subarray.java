class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int min[] = new int[n];
        int max[] = new int[n];
        min[0] = nums[0];
        max[0] = nums[0];
        int maxdp = nums[0];
        int mindp = nums[0];
        int tot = nums[0];
        for(int i = 1;i<n;i++){
            min[i] = Math.min(nums[i],min[i-1]+nums[i]);
            max[i] = Math.max(nums[i],max[i-1]+nums[i]);
            maxdp = Math.max(maxdp,max[i]);
            mindp = Math.min(mindp,min[i]);
            tot += nums[i];
        }
        if(maxdp<0) return maxdp;
        return Math.max(maxdp,tot-mindp);
    }
}