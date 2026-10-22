class KthLargest {
    PriorityQueue<Integer> pq;
    int max = 0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        for(int i = 0;i<nums.length;i++) pq.add(nums[i]);
        max = k;
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>max){
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */