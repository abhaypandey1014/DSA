class Solution {
    public int countCommas(int n) {
        String s = String.valueOf(n);
        if(s.length()>=4) return (n-1000)+1;
        else return 0;
    }
}