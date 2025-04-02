class Solution(object):
    def binarySearch(self, nums, target, areWeFindingForFirst):
        start, end = 0, len(nums) - 1
        result = -1

        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == target:
                result = mid
                if areWeFindingForFirst:
                    end = mid - 1
                else:
                    start = mid + 1
            elif nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return result

    def searchRange(self, nums, target):
        firstIndex = self.binarySearch(nums, target, True)
        if firstIndex == -1:
            return [-1, -1]
        lastIndex = self.binarySearch(nums, target, False)
        return [firstIndex, lastIndex]
