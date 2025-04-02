class Solution {
   public static int mySqrt(int x) {
        int start=0,end=x;

        while(start<=end){
            int mid=start+(end-start)/2;
            long value=(long) mid*mid;
            if(value==x){
                return mid;
            }
            if(value>x){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        return end;
    }

}