class Solution {
    public int par[];
    public int rank[];
    class Pair implements Comparable<Pair>{
        int val;
        int r;
        int c;
        public Pair(int val,int r,int c){
            this.val = val;
            this.r = r;
            this.c = c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.val-p2.val;
        }
    }
    public int find(int n){
        if(n==par[n]) return n;
        else return par[n] = find(par[n]);
    }
    public void unionrank(int a,int b){
        int parA = find(a);
        int parB = find(b);
        if(rank[parA]==rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB]) par[parA] = parB;
        else par[parB] = parA;
    }
    public int swimInWater(int[][] grid) {
        int max = 0;
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                max = Math.max(max,grid[i][j]);
                pq.add(new Pair(grid[i][j],i,j));
            }
        }
        par =  new int[n*n];
        rank = new int[n*n];
        for(int i = 0;i<n*n;i++){
            par[i] = i;
        }
        // Method 2--> Use this mapping technique instead of priorityqueue
        // int[][] pos = new int[n*n][2];
        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<n;j++){
        //         pos[grid[i][j]][0] = i;
        //         pos[grid[i][j]][1] = j;
        //     }
        // }
        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};
        boolean active[][] = new boolean[n][n];
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int row =  curr.r;
            int col = curr.c;
            active[row][col] = true;
            int ele = n*row+col;
            for(int i = 0;i<4;i++){
                int row1 = dr[i]+row;
                int col1 = dc[i]+col;
                if(row1<n && row1>=0 && col1>=0 && col1<n && active[row1][col1]){
                    int adj = row1*n+col1;
                    unionrank(ele,adj);
                }
            }
            if(find(0)==find(n*n-1))  return curr.val;
        }
        return -1;
    }
}