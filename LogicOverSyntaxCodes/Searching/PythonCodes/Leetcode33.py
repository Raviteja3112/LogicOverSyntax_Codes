class Solution(object):
    def binarySearch(self, nums, value, start, end):
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == value:
                return mid
            if nums[mid] > value:
                end = mid - 1
            else:
                start = mid + 1
        return -1

    def search(self, nums, target):
        start, end = 0, len(nums) - 1
        while start < end:
            mid = start + (end - start + 1) // 2
            if nums[start] > nums[mid]:
                end = mid - 1
            else:
                start = mid
        
        find_index = start

        index = self.binarySearch(nums, target, 0, find_index)
        if index != -1:
            return index
        return self.binarySearch(nums, target, find_index + 1, len(nums) - 1)
