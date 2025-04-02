class Solution {
   public static boolean isPerfectSquare(int num) {
        int start=1,end=num;
        
        while(start<end){
            int mid=start+(end-start)/2;
            if((long)mid*mid==num){
                return true;
            }
            if((long)mid*mid>num){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return (long)start*start==num;
    }
}