class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int len = m*n;
        int[] flat = new int[len];
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                flat[i*n+j] = grid[i][j];
            }
        }
        k = k%len;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<m;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j<n;j++){
                int idx = (len-k+(i*n+j))%len;
                list.add(flat[idx]);
            }
            res.add(list);
        }
        
        return res;
    }
}