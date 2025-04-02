class Solution {
    
    public static int findMin(int[] nums) {
        int start=0,end= nums.length-1;

        while(start<end){
            int mid=start+(end-start+1)/2;
            if(nums[start]>nums[mid]){
                end=mid-1;
            }
            else{
                start=mid;
            }
        }
        int findIndex=start;
        int minIndex=(findIndex+1)%nums.length;
        return nums[minIndex];
        
    }
    
}