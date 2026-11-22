class Solution {
    public boolean checkString(String s) {
        char arr[] = s.toCharArray();
        char brr[] = s.toCharArray();
        Arrays.sort(arr);
        int i = 0;
        while(i<arr.length){
            if(arr[i]==brr[i]) i++;
            else return false;
        }
        return true;
    }
}