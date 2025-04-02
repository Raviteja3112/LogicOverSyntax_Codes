/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    public int binarySearch(MountainArray nums,int target,boolean areWeApplyingForAsc,
    int start,int end){

        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums.get(mid)==target){
                return mid;
            }
            if(areWeApplyingForAsc){
                if(nums.get(mid)>target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(nums.get(mid)>target){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start=0,end=mountainArr.length()-1;

        while(start<end){
            int mid=start+(end-start)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        int peakIndex=start;
        int index=binarySearch(mountainArr,target,true,0,peakIndex);
        if(index!=-1){
            return index;
        }
        return binarySearch(mountainArr,target,false,peakIndex+1,mountainArr.length()-1);
    }
}

