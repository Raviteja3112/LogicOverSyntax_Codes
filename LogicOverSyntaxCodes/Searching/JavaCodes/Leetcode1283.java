class Solution {
   public static boolean canIPickThisNumber(int[] nums,int x,int threshold){
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=(nums[i]+x-1)/x;
            if(sum>threshold){
                return false;
            }
        }
        return true;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            max=Math.max(max,nums[i]);
        }
        int start=1,end=max;

        while(start<=end){
            int x=start+(end-start)/2;
            if(canIPickThisNumber(nums,x,threshold)){
                end=x-1;
            }
            else{
                start=x+1;
            }
        }
        return start;
    }
}