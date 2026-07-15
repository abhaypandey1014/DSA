class Solution {
    public int gcd(int a,int b){
        int ans = 1;
        for(int i = Math.min(a,b);i>=1;i--){
            if(a%i==0 && b%i==0){
                ans = i;
                break;
            }
        }
        return ans;
    }
    public int gcdOfOddEvenSums(int n) {
        int even = (n*(4+(n-1)*2))/2;
        int odd = (n*(2+(n-1)*2))/2;
        return gcd(even,odd);
    }
}