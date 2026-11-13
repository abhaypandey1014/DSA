class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int out[] = new int[graph.length];
        List<List<Integer>> rev = new ArrayList<>();
        for(int i = 0;i<n;i++) rev.add(new ArrayList<>());
        for(int i = 0;i<n;i++){
            out[i] = graph[i].length;
            for(int j = 0;j<graph[i].length;j++) rev.get(graph[i][j]).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        // helper(0,graph,ans,out);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<out.length;i++)
        {
            if(out[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            for(int i = 0;i<rev.get(curr).size();i++)
            {
                int next = rev.get(curr).get(i);
                out[next]--;
                if(out[next]==0) q.add(next);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}