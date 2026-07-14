class Solution {
    class Pair{
        String s;
        int idx;
        public Pair(String s,int idx){
            this.s = s;
            this.idx = idx;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            String curr = q.peek().s;
            int c = q.peek().idx;
            q.remove();
            if(curr.equals(endWord)) return c;
            for(int i = 0;i<curr.length();i++){
                for(char j = 'a';j<='z';j++){
                    char arr[] = curr.toCharArray();
                    arr[i] = j;
                    String next =  new String(arr);
                    if(set.contains(next)){
                        set.remove(next);
                        q.add(new Pair(next,c+1));
                    }
                }
            }
        }
        return 0;
    }
}