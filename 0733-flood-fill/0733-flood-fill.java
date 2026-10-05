class Solution {
    // public void dfs(int[][] image, int sr, int sc, int color,int main,boolean vis[][]){
    //     if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc]!=main) return;
    //     vis[sr][sc] = true;
    //     image[sr][sc] = color;
    //     dfs(image,sr+1,sc,color,main,vis);
    //     dfs(image,sr,sc+1,color,main,vis);
    //     dfs(image,sr-1,sc,color,main,vis);
    //     dfs(image,sr,sc-1,color,main,vis);
    //     return;
    // }
    class Pair{
        int r;
        int c;
        public Pair(int r,int c){
            this.r = r;
            this.c = c;
        } 
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        int main = image[sr][sc];
        vis[sr][sc] = true;
        while(!q.isEmpty()){
            Pair curr = q.remove();
            image[curr.r][curr.c] = color;
            int dr[] = {1,0,-1,0};
            int dc[] = {0,1,0,-1};
            for(int i = 0;i<4;i++){
                int nr = dr[i]+curr.r;
                int nc = dc[i]+curr.c;
                if(nr<0 || nc<0 || nr>=image.length || nc>=image[0].length || vis[nr][nc] || image[nr][nc]!=main) continue;
                vis[nr][nc] = true;
                q.add(new Pair(dr[i]+curr.r,dc[i]+curr.c));
            }
        }
        return image;
    }
}