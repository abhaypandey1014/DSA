class Solution{
    static class state implements Comparable<state>{
        int r;
        int c;
        int sum;
        public state(int r,int c,int sum){
            this.r = r;
            this.c = c;
            this.sum = sum;
        }
        public int compareTo(state s2)
        {
            return this.sum-s2.sum;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<state> pq = new PriorityQueue<>();
        pq.add(new state(0,0,0));
        int ans = Integer.MAX_VALUE;
        while(!pq.isEmpty())
        {
            state s = pq.remove();
            int row = s.r;
            int col = s.c;
            int total = s.sum;
            if(row==n-1 && col==m-1) {
                ans = Math.min(ans, s.sum);
            }
            if(total > dist[row][col]) continue;
        for(int i = 0;i < 4;i++)
        {
            int nr = dr[i] + row;
            int nc = dc[i] + col;
            if(nc<0 || nr<0 || nr>=n || nc>=m)continue;
            int diff = Math.abs(heights[nr][nc]-heights[row][col]);
            int newdiff = Math.max(diff,total);
            if(newdiff < dist[nr][nc]) {
                dist[nr][nc] = newdiff;
                pq.add(new state(nr,nc,newdiff));
            }
        }
        }
        return ans;
    }
}