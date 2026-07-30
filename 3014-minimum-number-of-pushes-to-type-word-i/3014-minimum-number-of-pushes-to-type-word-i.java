class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int c = n/8;
        return (c*(c+1)*4)+(n%8)*(c+1);
    }
}