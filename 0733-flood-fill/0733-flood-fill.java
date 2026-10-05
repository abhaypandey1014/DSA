class Solution {
    public void dfs(int[][] image, int sr, int sc, int color,int main,boolean vis[][]){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc]!=main) return;
        vis[sr][sc] = true;
        image[sr][sc] = color;
        dfs(image,sr+1,sc,color,main,vis);
        dfs(image,sr,sc+1,color,main,vis);
        dfs(image,sr-1,sc,color,main,vis);
        dfs(image,sr,sc-1,color,main,vis);
        return;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean vis[][] = new boolean[n][m];
        dfs(image,sr,sc,color,image[sr][sc],vis);
        return image;
    }
}