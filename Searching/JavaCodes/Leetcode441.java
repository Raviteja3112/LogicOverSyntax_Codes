class Solution {
    public static int arrangeCoins(int manaDaggaraUnnaCoins) {
       int start=1,end=manaDaggaraUnnaCoins;
       if(manaDaggaraUnnaCoins==1)return 1;
       while(start<end){
           int stairs=end+(start-end)/2;
           long enniKavali=(long)stairs*(stairs+1)/2;
           if(enniKavali>manaDaggaraUnnaCoins){
               end=stairs-1;
           }
           else{
               start=stairs;
           }
       }
       return start;
    }
}