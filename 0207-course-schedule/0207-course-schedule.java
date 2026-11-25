class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i<prerequisites.length;i++){
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            graph[src].add(dest);
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int indeg[] = new int[n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<graph[i].size();j++){
                int d = graph[i].get(j);
                indeg[d]++;
            }
        }
        for(int i = 0;i<n;i++) if(indeg[i]==0) q.add(i);
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            for(int i = 0;i<graph[curr].size();i++){
                int d = graph[curr].get(i);
                indeg[d]--;
                if(indeg[d]==0) q.add(d);
            }
        }
        return ans.size()==n;
    }
}