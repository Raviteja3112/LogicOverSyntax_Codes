class Solution {
    public static int binarySearch(int[] nums,int target){
        int start=0,end= nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }


    public static int[] intersect(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> list=new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            int target=a[i];
            int index=binarySearch(b,target);
            if(index!=-1){
                b[index]=-1;
                list.add(target);
                Arrays.sort(b);
            }
        }

        int[] result=new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=list.get(i);
        }
        return result;
    }

}