class Solution {
    public int[] par;
    public int[] rank;
    public int find(int n){
       if(n == par[n]) return n;
       return find(par[n]);
    }

    public void union(int x,int y){
        int parA = find(x);
        int parB = find(y);
        if(rank[parA]==rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA]>rank[parB]) par[parB] = parA;
        else par[parA] = parB;
    }
    public int makeConnected(int n, int[][] connections) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        par = new int[n];
        for(int i = 0;i<n;i++){
            par[i] = i;
        }
        rank = new int[n];
        int ext = 0;
        for(int i = 0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(find(u)==find(v)) ext++;
            else union(u,v);
        }
        int c = 0;
        for(int i = 0;i<n;i++){
            if(par[i]==i) c++;
        }
        return c-1<=ext?c-1:-1;
    }
}