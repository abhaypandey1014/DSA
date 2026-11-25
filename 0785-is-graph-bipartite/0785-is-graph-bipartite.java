class Solution {
    public boolean isBipartite(int[][] edge) {
        int n = edge.length;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i = 0;i<n;i++) graph[i] = new ArrayList<>();
        for(int i = 0;i<edge.length;i++){
            for(int j = 0;j<edge[i].length;j++){
                int dest = edge[i][j];
                graph[i].add(dest);
                graph[dest].add(i);
            }
        }
        int arr[] = new int[n];
        Arrays.fill(arr,-1);
        Queue<Integer> q = new LinkedList<>();
        for(int j = 0;j<n;j++){
            if(arr[j]==-1){
            q.add(j);
            arr[j] = 0;
            while(!q.isEmpty()){
                int curr = q.remove();
                for(int i=0;i<graph[curr].size();i++){
                    int dest = graph[curr].get(i);
                    if(arr[dest]==-1){
                        q.add(dest);
                        arr[dest] = 1-arr[curr];
                    }
                    else if(arr[dest]==arr[curr])return false;
                }
            }
            }
        }
        return true;
    }
}