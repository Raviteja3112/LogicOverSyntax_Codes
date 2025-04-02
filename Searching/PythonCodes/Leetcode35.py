class Solution(object):
    def searchInsert(self, nums, target):
       
        start, end = 0, len(nums) - 1

        while start <= end:
            mid = end + (start - end) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        
        return start
