class Solution {
    public int countDigits(int num) {
        int n = num;
        int arr[] = new int[10];
        while(n!=0){
            int rem = n%10;
            arr[rem]++;
            n /= 10;
        }
        int c = 0;
        for(int i = 0;i<10;i++){
            if(arr[i]!=0 && num%i==0) c+=arr[i];
        }
        return c;
    }
}