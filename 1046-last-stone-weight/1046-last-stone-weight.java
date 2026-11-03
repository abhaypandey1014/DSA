class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<stones.length;i++) pq.add(stones[i]);
        // if(stones.length)
        while(pq.size()>1){
            int top1 = pq.remove();
            int top2 = pq.remove();
            pq.add(top1-top2);
        }
        return pq.peek();
    }
}