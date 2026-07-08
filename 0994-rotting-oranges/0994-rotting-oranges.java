class Solution {
    class Pair {
        int x;
        int y;
        int c;
        public Pair(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = -1;
                }
            }
        }
        int c = 0;
        while(!q.isEmpty()){
            Pair curr = q.remove();
            int x1 = curr.x;
            int y1 = curr.y;
            c = Math.max(c,curr.c);
            int l = y1-1;
            int r = y1+1;
            int u = x1-1;
            int d = x1+1;
            if(x1>=0 && x1<n && y1>=0 && y1<m && d<n && vis[d][y1]!=-1 && grid[d][y1]==1){
                vis[d][y1] = -1;
                grid[d][y1] = 2;
                q.add(new Pair(d,y1,curr.c+1));
            }
            if(x1>=0 && x1<n && y1>=0 && y1<m && u>=0 && vis[u][y1]!=-1 && grid[u][y1]==1){
                vis[u][y1] = -1;
                grid[u][y1] = 2;
                q.add(new Pair(u,y1,curr.c+1));
            }
            if(x1>=0 && x1<n && y1>=0 && y1<m && l>=0 && vis[x1][l]!=-1 && grid[x1][l]==1){
                vis[x1][l] = -1;
                grid[x1][l] = 2;
                q.add(new Pair(x1,l,curr.c+1));
            }
            if(x1>=0 && x1<n && y1>=0 && y1<m && r<m && vis[x1][r]!=-1 && grid[x1][r]==1){
                vis[x1][r] = -1;
                grid[x1][r] = 2;
                q.add(new Pair(x1,r,curr.c+1));
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return c;
    }
}