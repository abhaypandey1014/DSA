class Solution {
    public int maxScore(int[] nums, int k) {
        int n =  nums.length;
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum += nums[i];
        }
        max = Math.max(sum,max);
        for(int i = 0;i<k;i++){
            sum -= nums[k-i-1];
            sum += nums[n-i-1];
            max = Math.max(max,sum);
        }
        return max;
    }
}