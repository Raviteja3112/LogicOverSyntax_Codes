class Solution {
    public static int binarySearch(int[] nums,int value,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==value){
                return mid;
            }
            if(nums[mid]>value){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }

    public static boolean search(int[] nums, int target) {
        int start=0,end= nums.length-1;

        while(start<end){
            int mid=start+(end-start+1)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[start]==nums[end]){
                start++;
                end--;
                continue;
            }
            if(nums[start]>nums[mid]){
                end=mid-1;
            }
            else{
                start=mid;
            }
        }
        int findIndex=start;

        int index=binarySearch(nums,target,0,findIndex);
        if(index!=-1){
            return true;
        }
        return binarySearch(nums,target,findIndex+1, nums.length-1)!=-1;
    }
}