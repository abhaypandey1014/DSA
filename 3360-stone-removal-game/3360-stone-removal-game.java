class Solution {
    public boolean poss(int n ,boolean t,int need){
        if(n<need) return t;
        return poss(n-need,!t,need-1);
    }
    public boolean canAliceWin(int n) {
        if(n<10) return false;
        if(n<19) return true;
        return poss(n-10,true,9);
    }
}