class Solution {
    public boolean valid(int n,int t){
        int mul = 1;
        while(n!=0){
            int rem = n%10;
            mul *= rem;
            n /= 10;
        }
        return mul%t==0;
    }
    public int smallestNumber(int n, int t) {
        int ans = 0;
        int b = 0;
        for(int i = n;i<=100;i++){
            if(valid(i,t)){
                b = i;
                break;
            }
        } 
        return b;
    }
}