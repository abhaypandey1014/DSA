class Solution {
    class Pair implements Comparable <Pair>{
        int n;
        double p;
        public Pair(int n,double p){
            this.n = n;
            this.p = p;
        }
        @Override
        public int compareTo(Pair p2){
            return Double.compare(p2.p,this.p);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double dist[] = new double[n];
        Arrays.fill(dist,0.0);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[start] = 1.0;
        boolean vis[] = new boolean[n];
        ArrayList<double []> graph[] = new ArrayList[n];
        for(int i = 0;i<n;i++) graph[i] = new ArrayList<>();
        for(int i = 0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            double wt = succProb[i];
            graph[src].add(new double[]{dest,wt});
            graph[dest].add(new double[]{src,wt});
        }
        pq.add(new Pair(start,1.0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int node = curr.n;
            if(!vis[node]){
                vis[node] = true;
                if(node==end) return dist[end];
                for(int i = 0;i<graph[node].size();i++){
                    double[] Edge = graph[node].get(i);
                    int v = (int)Edge[0];
                    double w = Edge[1];
                    if(!vis[v] && dist[node]*w>dist[v]){
                        dist[v] = dist[node]*w;
                        pq.add(new Pair((int)v,dist[v]));
                    }
                }
            }
        }
        return 0.0;
    }
}