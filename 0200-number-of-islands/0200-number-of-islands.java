class Solution {
    class Pair{
        int r;
        int c;
        public Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    public int numIslands(char[][] grid) {
        int dr[] = {1,0,-1,0};
        int dc[] = {0,-1,0,1};
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    grid[i][j] = '0';
                    q.add(new Pair(i,j));
                    while(!q.isEmpty()){
                        Pair curr = q.remove();
                        for(int k = 0;k<4;k++){
                            int nr = dr[k]+curr.r;
                            int nc = dc[k]+curr.c;
                            if(nr<0 || nc<0 || nr>=n || nc>=m || grid[nr][nc]=='0') continue;
                            grid[nr][nc] = '0';
                            q.add(new Pair(nr,nc));
                            }
                        }
                    }
                }
            }
        return count;
    }
}
