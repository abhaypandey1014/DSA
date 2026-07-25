class Solution {
    public int help(int nums[],int goal){
        int ans = 0;
        int sum = 0;
        int left = 0;
        if(goal<0) return 0;
        for(int right = 0;right<nums.length;right++){
            sum += nums[right];
            while(sum>goal){
                sum -= nums[left];
                left++;
            }
            ans += right-left+1;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum1 = 0;
        int ans = 0;
        return help(nums,goal)-help(nums,goal-1);
    }
}