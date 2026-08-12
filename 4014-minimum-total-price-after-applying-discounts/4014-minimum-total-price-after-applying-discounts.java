class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        double ans = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int j = discounts.length-1;
        int i = prices.length-1;
        while(i>=0 && j>=0){
            ans += (double)((prices[i])*(100-discounts[j]))/100;
            System.out.println(ans+" ");
            i--;
            j--;
        }
        for(int k = 0;k<=i;k++) ans += prices[k];
        return ans;
    }
}