class Solution {
    class Pair implements Comparable<Pair>{
        int par;
        int val;
        int d;
        public Pair(int par,int val,int d){
            this.par = par;
            this.val = val;
            this.d = d;
        }
        public int compareTo(Pair p2){ 
            return this.par - p2.par;
        } 
    }
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        int h = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dep[] = new int[n];
        dep[0] = 1;
        for(int i = 1;i<n;i++){
            if(dep[i] != 0){
                h = Math.max(h,dep[i]);
                continue;
            }
            int curr = i;
            int depth = 0;
            while(dep[curr] == 0){
                depth++;
                curr = parent[curr];
            }
            int base = dep[curr];
            curr = i;
            while(dep[curr] == 0){
                dep[curr] = base + depth;
                depth--;
                curr = parent[curr];
            }
            h = Math.max(h,dep[i]);
        }
        for(int i = 0;i<n;i++) pq.add(new Pair(parent[i],nums[i],dep[i]));
        long ans = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int num = curr.val;
            int depth = curr.d;
            ans += (long)num*(h-depth+1);
        }
        return ans;
    }
}