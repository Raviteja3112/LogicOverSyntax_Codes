class Solution {
   public static boolean canIEatWithKCapacity(int[] nums,int capacity,int hours){
        for(int i=0;i< nums.length;i++){
            if(hours<0){
                return false;
            }
            int bananas=nums[i];
            int hourToFinish=(bananas+capacity-1)/capacity;
            hours-=hourToFinish;
        }
        return hours>=0;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max=0;

        for (int i = 0; i < piles.length; i++) {
            max=Math.max(max,piles[i]);
        }
        int start=1,end=max;

        while(start<end){
            int capacity=start+(end-start)/2;
            if(canIEatWithKCapacity(piles,capacity,h)){
                end=capacity;
            }
            else{
                start=capacity+1;
            }
        }
        return start;
    }
}