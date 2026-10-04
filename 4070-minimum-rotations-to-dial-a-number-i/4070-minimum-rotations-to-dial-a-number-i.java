class Solution {
    public int minRotations(String s) {
        int ans = 0;
        int curr = 0;
        for(char ch : s.toCharArray()){
            int tar = ch-'0';
            int diff = Math.abs(curr-tar);
            ans += Math.min(diff,10-diff);
            curr = tar;
        }
        return ans;
    }
}
