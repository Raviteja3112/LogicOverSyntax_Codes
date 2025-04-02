class Solution {
    public static int binarSearch(int[] nums,int target,int index){
        int start=index,end= nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int find=target-numbers[i];
            int index=binarSearch(numbers,find,i+1);
            if(index!=-1){
                return new int[]{i+1,index+1};
            }
        }
        return new int[]{0,0};
    }
}