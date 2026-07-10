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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map =  new HashMap<>();
        int n = accounts.size();
        par = new int[n];
        for(int i = 0;i<n;i++){
            par[i] = i; 
        }
        rank = new int[n];
        for(int i = 0;i<n;i++){
            List<String> list = accounts.get(i);
            for(int j = 1;j<list.size();j++){
                if(!map.containsKey(list.get(j))){
                    map.put(list.get(j),i);
                }
                else union(i,map.get(list.get(j)));
            }
        }
        HashMap<Integer,Set<String>> map1 = new HashMap<>();
        for(String key:map.keySet()){
            int head = find(map.get(key));
            map1.putIfAbsent(head,new TreeSet<>());
            map1.get(head).add(key);
        }
        List<List<String>> res = new ArrayList<>();
        for(int key:map1.keySet()){
            List<String> list = new ArrayList<>();
            list.add(accounts.get(key).get(0));
            list.addAll(map1.get(key));
            res.add(list);
        }
        return res;
    }
}