class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        int n = nums1.length;
        int odd = 0;
        for(int i = 0;i<nums1.length;i++){
            if((nums1[i]&1)==1){
            odd++;
            }
        }
        if(odd==0) return true;
        if(nums1[0]%2==0) return false;
        return true;
    }
}