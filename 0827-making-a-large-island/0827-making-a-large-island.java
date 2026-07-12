class Solution {
    public int par[];
    public int rank[];
    public boolean valid(int r,int c,int n){
        return (r<n && r>=0 && c<n && c>=0);
    }
    public int find(int x){
        if(x==par[x]) return x;
        else return par[x] = find(par[x]);
    }
    public void union(int a,int b){
        int parA = find(a);
        int parB = find(b);
        if(parA == parB) return;
        if(rank[parA]<rank[parB]) {
            par[parA] = parB;
            rank[parB] += rank[parA];
        } else{
            par[parB] = parA;
            rank[parA] += rank[parB];
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        par = new int[n*n];
        rank = new int[n*n];
        for(int i = 0;i<n*n;i++){
            par[i] = i;
            rank[i] = 1;
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==0) continue;
                int dr[] = {1,-1,0,0};
                int dc[] = {0,0,-1,1};
                for(int k = 0;k<4;k++){
                    int nr = dr[k]+i;
                    int nc = dc[k]+j;
                    if(valid(nr,nc,n) && grid[nr][nc]==1){
                        int curr = n*i + j;
                        int adj = n*nr + nc;
                        union(curr,adj);
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==1) continue;
                int dr[] = {1,-1,0,0};
                int dc[] = {0,0,-1,1};
                HashSet<Integer> set = new HashSet();
                for(int k = 0;k<4;k++){
                    int nr = dr[k]+i;
                    int nc = dc[k]+j;
                    if(valid(nr,nc,n)){
                        int adj = n*nr + nc;
                        if(grid[nr][nc]==1){
                            set.add(find(adj));
                        }
                    }
                }
                int ans = 1;
                for(int ele:set){
                    ans += rank[ele];
                }
                max = Math.max(ans,max);
            }
        }
        for(int i = 0;i<n*n;i++){
        if(par[i]==i) max = Math.max(max,rank[i]);
        }
        return max;
    }
}