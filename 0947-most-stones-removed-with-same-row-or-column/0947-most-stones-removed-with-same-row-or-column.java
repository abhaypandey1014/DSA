class Solution {
    public int par[];
    public int rank[];
    public int size[];
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
    public void unionsize(int a,int b){
        int parA = find(a);
        int parB = find(b);
        if(parA==parB) return;
        if(size[parA]<size[parB]){
            par[parA] = parB;
            size[parB] += size[parA];
        }
        else {
            par[parB] = parA;
            size[parA] += size[parB];
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxrow = 0;
        int maxcol = 0;
        for(int i = 0;i<n;i++){
            maxrow = Math.max(maxrow,stones[i][0]);
            maxcol = Math.max(maxcol,stones[i][1]);
        }
        par =  new int[maxrow+maxcol+2];
        rank = new int[maxrow+maxcol+2];
        size = new int[maxrow+maxcol+2];
        Arrays.fill(size,1);
        for(int i = 0;i<maxrow+maxcol+2;i++){
            par[i] = i;
        }
        HashMap<Integer,Integer> map  = new HashMap<>();
        for(int i = 0;i<n;i++){
            int row = stones[i][0];
            int col = maxrow+stones[i][1]+1;
            unionsize(row,col);
            map.put(row,1);
            map.put(col,1);
        }
        int c = 0;
        for(int key:map.keySet()){
            if(find(key)==key) c++;
        }
        return n-c;
    }
}