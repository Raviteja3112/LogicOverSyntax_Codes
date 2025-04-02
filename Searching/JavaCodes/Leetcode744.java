class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int start=0,end=letters.length-1;

        while(start<end){
            int mid=start+(end-start)/2;
            if(target>=letters[mid]){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return letters[start]>target?letters[start]:letters[0];
    }
}