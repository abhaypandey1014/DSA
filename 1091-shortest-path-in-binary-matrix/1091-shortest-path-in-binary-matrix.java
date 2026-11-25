class Solution {
    class Pair{
        int x;
        int y;
        int lvl;
        public Pair(int x,int y,int lvl){
            this.x = x;
            this.y = y;
            this.lvl = lvl;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
       if(grid[0][0]==1) return -1;
       int n = grid.length;
       int m = grid[0].length;
       int dr[] = {0,0,1,-1,1,-1,1,-1};
       int dc[] = {1,-1,0,0,1,-1,-1,1};
       int ans = Integer.MAX_VALUE;
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(0,0,1)); 
       int count = 0;
       while(!q.isEmpty()){
        Pair curr = q.remove();
        int x = curr.x;
        int y = curr.y;
        if(x==n-1 && y==m-1) ans = Math.min(ans,curr.lvl);
        for(int i = 0;i<8;i++){
            int nr = x+dr[i];
            int nc = y+dc[i];
            if(nr>=n || nc>=m || nr<0 || nc<0 || grid[nr][nc]==1) continue;
            q.add(new Pair(nr,nc,curr.lvl+1));
            grid[nr][nc] = 1;
        }
       }
       return ans==Integer.MAX_VALUE?-1:ans;
    }
}