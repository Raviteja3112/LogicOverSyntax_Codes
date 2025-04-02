class Solution(object):
    def binary_search(self, nums, value, start, end):
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
            if nums[mid] == target:
                return True
            if nums[start] == nums[end]:
                start += 1
                end -= 1
                continue
            if nums[start] > nums[mid]:
                end = mid - 1
            else:
                start = mid

        find_index = start
        index = self.binary_search(nums, target, 0, find_index)
        if index != -1:
            return True
        return self.binary_search(nums, target, find_index + 1, len(nums) - 1) != -1
