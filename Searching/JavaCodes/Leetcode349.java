class Solution {
    public static boolean binarySearch(int[] nums,int target){
        int start=0,end= nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return false;
    }


    public static int[] intersection(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> list=new ArrayList<>();
        boolean[] didWeTrackedAlready=new boolean[10001];


        for (int i = 0; i < a.length; i++) {
            int target=a[i];
            if(didWeTrackedAlready[target]){
                continue;
            }
            didWeTrackedAlready[target]=true;
            if(binarySearch(b,target)){
                list.add(target);
            }
        }

        int[] result=new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=list.get(i);
        }
        return result;
    }
}