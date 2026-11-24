class Solution {
    int par[];
    int rank[];
    public int find(int n){
        if(n==par[n]) return n;
        return par[n] = find(par[n]);
    }
    public void union(int a,int b){
        int parA = find(a);
        int parB = find(b);
        if(rank[parA]==rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB]) par[parA] = parB;
        else par[parB] = parA;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        par = new int[n];
        rank = new int[n];
        for(int i = 0;i<n;i++) par[i] = i;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            List<String> list = accounts.get(i);
            for(int j = 1;j<list.size();j++){
                if(!map.containsKey(list.get(j))) map.put(list.get(j),i);
                else union(map.get(list.get(j)),i);
            }
        }
        HashMap<Integer,TreeSet<String>> map1 = new HashMap<>();
        for(String key:map.keySet()){
            int head = find(map.get(key));
            map1.putIfAbsent(head,new TreeSet<>());
            map1.get(head).add(key);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int key:map1.keySet()){
            List<String> list = new ArrayList<>();
            list.add(accounts.get(key).get(0));
            list.addAll(map1.get(key));
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}