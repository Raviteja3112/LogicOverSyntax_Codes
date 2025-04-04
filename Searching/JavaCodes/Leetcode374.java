/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
    
        int start=1,end=n;

        while(start<=end){
            int pick=start+(end-start)/2;
            int value=guess(pick);
            if(value==0){
                return pick;
            }
            if(value==1){
                start=pick+1;
            }
            else{
                end=pick-1;
            }
        }
        
        return -2;
    }
}