class Solution {
    public static int binarySearch(int[] nums,int target,boolean areWeFindingForFirst){
        int start=0,end= nums.length-1;

        int addIt=areWeFindingForFirst?0:1;

        while(start<end){
            int mid=start+(end-start+addIt)/2;
            if(areWeFindingForFirst){
                if(nums[mid]<target){
                    start=mid+1;
                }
                else{
                    end=mid;
                }
            }
            else{
                if(nums[mid]<=target){
                    start=mid;
                }
                else {
                    end=mid-1;
                }
            }
        }
        return nums[start]==target?start:-1;
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0)return new int[]{-1,-1};
        int firstIndex=binarySearch(nums,target,true);
        if(firstIndex==-1){
            return new int[]{-1,-1};
        }
        int lastIndex=binarySearch(nums,target,false);
        return new int[]{firstIndex,lastIndex};
    }
}