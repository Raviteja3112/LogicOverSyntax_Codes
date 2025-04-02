class Solution {
   public static int singleNonDuplicate(int[] nums) {
        int start=0,end= nums.length-1;

        while(start<end){
            int mid=start+(end-start)/2;
            int whichIndex=mid%2==0?mid+1:mid-1;
            if(nums[mid]==nums[whichIndex]){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return nums[start];
    }
}