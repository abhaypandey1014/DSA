class Solution {
    public int help(ArrayList<Integer> arr,int i,TreeMap<Integer,Integer> map,int dp[]){
        if(i>=arr.size()) return 0;
        int sum1 = 0;
        int sum2 = 0;
        if(dp[i]!=-1) return dp[i];
        sum2 = help(arr,i+1,map,dp);
        int next = i+1;
        if(next<arr.size() && arr.get(next)==arr.get(i)+1) next++;
        sum1 = map.get(arr.get(i))*arr.get(i)+help(arr,next,map,dp);
        return dp[i] = Math.max(sum1,sum2);
    }
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            int a = nums[i];
            map.put(a,map.getOrDefault(a,0)+1);
        }
        ArrayList<Integer> arr = new ArrayList<>(map.keySet());
        int dp[] = new int[arr.size()];
        Arrays.fill(dp,-1);
        return help(arr,0,map,dp);
    }
}