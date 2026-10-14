class Solution {
    public String maxSumOfSquares(int n, int sum) {
        if(sum>9*n) return "";
        StringBuilder sb = new StringBuilder();
        int j = n;
        while(j>0){
            sb.append("9");
            j--;
        }
        int curr = 9*n;
        int diff = curr-sum;
        int pos = diff/9;
        int minus = diff%9;
        System.out.println(diff+" "+minus+" "+sb);
        int k = sb.length()-1;
        while(pos>0){
            sb.setCharAt(k,'0');
            pos--;
            k--;
        }
        int num = 9-minus;
        char ch = (char)('0'+num);
        
        sb.setCharAt(k,ch);
        return sb.toString();
    }
}