class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        ArrayList<Boolean> prev = new ArrayList<>();
        prev.add(true);
        for(int i = 1;i<=m;i++){
            if(p.charAt(i-1)=='*') prev.add(prev.get(i-1));
            else prev.add(false);
        }
        for(int i = 1;i<=n;i++){
            ArrayList<Boolean> next = new ArrayList<>();
            next.add(false);
            for(int j = 1;j<=m;j++){
                if((s.charAt(i-1)==p.charAt(j-1)) || (p.charAt(j-1)=='?')) next.add(prev.get(j-1));
                else if(p.charAt(j-1)=='*') next.add(prev.get(j)||next.get(j-1));
                else next.add(false);
            }
            prev = new ArrayList<>(next);
        }
        return prev.get(m);
    }
}