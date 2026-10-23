class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0;i<senate.length();i++){
            if(senate.charAt(i)=='R') q1.add(i);
            else q2.add(i);
        }
        int n = senate.length();
        while(!q1.isEmpty() && !q2.isEmpty()){
            int idx1 = q1.peek();
            int idx2 = q2.peek();
            if(idx1>idx2){
                q2.add(n);
            }
            else{
                q1.add(n);
            }
            q1.remove();
            q2.remove();
            n++;
        }
        if(q1.isEmpty()) return "Dire";
        else return "Radiant";
    }
}