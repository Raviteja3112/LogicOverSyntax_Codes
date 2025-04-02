class Solution {
   public static boolean canIMakeBouquet(int[] bloomDay,int m,int k,int day){
        int bouquets=0,flowers=0;
        for (int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i]<=day){
                flowers++;
            }
            else{
                flowers=0;
            }
            if(flowers==k){
                bouquets++;
                flowers=0;
            }
            if(bouquets==m){
                return true;
            }
        }
        return false;
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k> bloomDay.length){
            return -1;
        }
        int max=0;
        for (int i = 0; i < bloomDay.length; i++) {
            max=Math.max(max,bloomDay[i]);
        }
        int start=1,end=max;

        while(start<=end){
            int day=start+(end-start)/2;
            if(canIMakeBouquet(bloomDay,m,k,day)){
                end=day-1;
            }
            else{
                start=day+1;
            }
        }
        return start;
    }
}