class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        System.out.println(ans);
        for(int i=0;i<n;i++)
        {
            if(i > 0 && arr[i]==arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j < k)
            {
                int sum = arr[i]+arr[j]+arr[k];
                    if(sum==0)
                    {
                    List<Integer> list=new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);
                    // System.out.println(list.get(0)+"--->"+list.get(1)+"--->"+list.get(2));
                    ans.add(list);
                    // System.out.println(ans);
                    j++;
                    k--;
                    while(j < k && arr[j]==arr[j-1]) j++;
                    }
                    else if(sum > 0) k--;
                    else j++;
                }
        }
        return ans;
    }
}