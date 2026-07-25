class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        int right = 0;
        for(right = 0;right<fruits.length;right++){
            int a = fruits[right];
            map.put(a,map.getOrDefault(a,0)+1);
            while(map.size()>2){
                max = Math.max(max,right-left);
                map.put(fruits[left],map.getOrDefault(fruits[left],0)-1);
                if(map.get(fruits[left])==0) map.remove(fruits[left]);
                left++;
            }
        }
        max = Math.max(max,right-left);
        return max;
    }
}