class Solution {
    public void moveZeroes(int[] arr) {
        int j=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[j++]=arr[i];
            }
        }
        while(j<n)
            arr[j++]=0;
    }
}