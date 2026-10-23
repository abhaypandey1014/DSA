class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        long pre[] = new long[nums.length+1];
        int n = nums.length;
        pre[0] = 0;
        dq.offerLast(0);
        int i = 1;
        int min = Integer.MAX_VALUE;
        while(i<=n){
            pre[i] = pre[i-1]+nums[i-1];
            while(!dq.isEmpty() && pre[i]<pre[dq.peekLast()]) dq.pollLast();
            while(!dq.isEmpty() && pre[i]-pre[dq.peekFirst()]>=k){
                min = Math.min(min,i-dq.peekFirst());
                dq.pollFirst();
            }
            dq.offerLast(i);
            i++;
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}