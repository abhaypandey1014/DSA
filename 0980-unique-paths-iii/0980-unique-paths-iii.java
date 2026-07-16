class Solution {
    public int help(int r,int c,int count,int grid[][]){
        if(r>grid.length-1 || c>grid[0].length-1 || r<0 || c<0 || grid[r][c]==-1) return 0;
        if(grid[r][c]==2) return count==-1?1:0;
        grid[r][c] = -1;
        count--;
        int left = help(r,c-1,count,grid);
        int right = help(r,c+1,count,grid);
        int up = help(r-1,c,count,grid);
        int down = help(r+1,c,count,grid);
        int total = left+right+up+down;
        grid[r][c] = 0;
        count++;
        return total;
    }
    public int uniquePathsIII(int[][] grid) {
        int r = 0;
        int c = 0;
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==0) count++;
                else if(grid[i][j]==1){
                    r = i;
                    c = j;
                }
            }
        }
        return help(r,c,count,grid);
    }
}