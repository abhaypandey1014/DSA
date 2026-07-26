class Solution {
    public int largestInteger(int n, int s) {
        int sum = s;
        int ans = 0;
        if(s == 0) return 0;
        if(s>9*n) return -1;
        while(n!=0){
            ans = ans*10+Math.min(9,s);
            s -= Math.min(9,s);
            n--;
        }
        return ans;
    }
}