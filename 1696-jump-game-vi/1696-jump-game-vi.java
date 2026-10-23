class Solution {
    public int maxResult(int[] nums, int k) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(0);
        for(int i = 1;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<i-k) dq.pollFirst();
            dp[i] = nums[i]+dp[dq.peekFirst()];
            while(!dq.isEmpty() && dp[dq.peekLast()]<=dp[i]) dq.pollLast();
            dq.offerLast(i);
        }
        return dp[nums.length-1];
    }
}