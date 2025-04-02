class Solution {
    public static boolean canISplitAtMaxK(int[] nums,int k,int maxSum){
        int tempK=1,sum=0;

        for (int i = 0; i < nums.length; i++) {
            if(sum+nums[i]<=maxSum){
                sum+=nums[i];
            }
            else{
                tempK++;
                sum=nums[i];
            }
        }
        return tempK<=k;
    }

    public static int splitArray(int[] nums, int k) {
        int max=0,sum=0;
        for (int i = 0; i < nums.length; i++) {
            max=Math.max(max,nums[i]);
            sum+=nums[i];
        }
        int start=max,end=sum;

        while(start<end){
            int mid=start+(end-start)/2;
            if(canISplitAtMaxK(nums,k,mid)){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return end;
    }
}