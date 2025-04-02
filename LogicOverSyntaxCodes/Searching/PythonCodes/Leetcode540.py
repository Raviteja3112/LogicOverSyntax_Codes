class Solution:
    def singleNonDuplicate(self, nums):
        start, end = 0, len(nums) - 1

        while start < end:
            mid = start + (end - start) // 2
            which_index = mid + 1 if mid % 2 == 0 else mid - 1
            
            if nums[mid] == nums[which_index]:
                start = mid + 1
            else:
                end = mid

        return nums[start]
