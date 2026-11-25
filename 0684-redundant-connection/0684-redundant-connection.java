class Solution {
    int par[];
    int size[];
    public int find(int n){
        if(n==par[n]) return n;
        return par[n] = find(par[n]);
    }
    public void union(int a,int b){
        int A = find(a);
        int B = find(b);
        if(size[A]>size[B]){
            par[B] = A;
            size[A] += size[B];
        }
        else{
            par[A] = B;
            size[B] += size[A];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n+1];
        size = new int[n+1];
        for(int i = 0;i<par.length;i++){
            par[i] = i;
            size[i] = 1;
        }
        for(int i = 0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(find(u)==find(v)) return new int[]{u,v};
            union(u,v);
        }
        return new int[0];
    }
}