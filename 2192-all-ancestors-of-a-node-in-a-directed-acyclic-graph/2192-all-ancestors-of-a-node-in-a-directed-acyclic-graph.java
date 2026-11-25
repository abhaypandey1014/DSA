class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i = 0;i<n;i++) graph[i] = new ArrayList<>();
        int indeg[] = new int[n];
        TreeSet<Integer> ans[] = new TreeSet[n];
        for(int i = 0;i<n;i++) ans[i] = new TreeSet<>();
        List<List<Integer>> res = new ArrayList<>();
        // for(int i = 0;i<n;i++) ans.add(new ArrayList<>());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            indeg[dest]++;
            graph[src].add(dest);
        }
        for(int i = 0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int j = 0;j<graph[curr].size();j++){
                int nei = graph[curr].get(j);
                ans[nei].addAll(ans[curr]);
                ans[nei].add(curr);
                indeg[nei]--;
                if(indeg[nei]==0) q.add(nei);
            }
        }
        for(int i = 0;i<n;i++){
            res.add(new ArrayList<>(ans[i]));
        }
        return res;
    }
}