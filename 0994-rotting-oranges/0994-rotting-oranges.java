class Solution {
    class Pair{
        int x;
        int y;
        int c;
        public Pair(int x,int y,int c){
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
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = -1;
                }
            }
        }
        int c = 0;
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};
        while(!q.isEmpty()){
            Pair curr = q.remove();
            int x1 = curr.x;
            int y1 = curr.y;
            c = Math.max(c, curr.c);
            for(int i = 0;i<4;i++){
                int nr = dr[i]+x1;
                int nc = dc[i]+y1;
                if(nr<0 || nc<0 || nr>=n || nc>=m || grid[nr][nc]==0 || vis[nr][nc]==-1) continue;
                grid[nr][nc] = 2;
                vis[nr][nc] = -1;
                q.add(new Pair(nr,nc,c+1));
                
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