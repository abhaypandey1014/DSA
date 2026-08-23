class Solution {
    public boolean isPalindromic(String s) {
        int n = s.length();
        for(int i = 0;i<=n/2;i++){
            int left = s.charAt(i);
            int right = s.charAt(n-1-i);
            for(int j = 0;j<8;j++){
                int lBit = (left>>j)&1;
                int rBit = (right>>(7-j))&1;
                if(lBit!=rBit) return false;
            }
        }
        return true;
    }
}