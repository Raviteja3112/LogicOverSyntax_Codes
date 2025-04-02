class Solution {
    public static boolean canITransport(int[] weights,int days,int capacity){
        int shipWeight=0;
        int tempDays=1;

        for (int i = 0; i < weights.length; i++) {
            if(shipWeight+weights[i]<=capacity){
                shipWeight+=weights[i];
            }
            else{
                tempDays++;
                shipWeight=weights[i];
            }
        }
        return tempDays<=days;
    }
    public static int shipWithinDays(int[] weights, int days) {
        int max=0,sum=0;

        for (int i = 0; i < weights.length; i++) {
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        
        int start=max,end=sum;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(canITransport(weights,days,mid)) {
                end = mid - 1;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
}