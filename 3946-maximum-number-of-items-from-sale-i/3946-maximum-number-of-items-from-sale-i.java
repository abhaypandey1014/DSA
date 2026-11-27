class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int dp[] = new int[budget+1];
        Arrays.fill(dp,-1);
        int factor[] = new int[n];
        dp[0] = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            min = Math.min(items[i][1],min);
            for(int j = 0;j<n;j++){
                if(i!=j && items[j][0]%items[i][0]==0) factor[i]++;
            }
        }
        for(int i = 0;i<n;i++){
            int cost = items[i][1];
            int profit = 1+factor[i];
            for(int j = budget;j>=cost;j--){
                if(dp[j-cost]!=-1){
                    dp[j] = Math.max(dp[j],dp[j-cost]+profit);
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<=budget;i++){
            if(dp[i]!=-1){
                int ex = (budget-i)/min;
                ans = Math.max(dp[i]+ex,ans);
            }
        }
        return ans;
    }
}