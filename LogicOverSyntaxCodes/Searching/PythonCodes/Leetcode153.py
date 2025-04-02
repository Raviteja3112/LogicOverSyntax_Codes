class Solution(object):
    def findMin(self, nums):
        start, end = 0, len(nums) - 1

        while start < end:
            mid = start + (end - start + 1) // 2
            if nums[start] > nums[mid]:
                end = mid - 1
            else:
                start = mid

        find_index = start
        min_index = (find_index + 1) % len(nums)
        return nums[min_index]
