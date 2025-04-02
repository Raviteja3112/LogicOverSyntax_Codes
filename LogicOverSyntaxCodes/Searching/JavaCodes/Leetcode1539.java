class Solution {
   public static int findKthPositive(int[] arr, int k) {
        int start=0,end=arr.length-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            int oneBasedIndexed=mid+1;
            int missingElements=arr[mid]-oneBasedIndexed;
            if(k>missingElements){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start+k;
    }
}