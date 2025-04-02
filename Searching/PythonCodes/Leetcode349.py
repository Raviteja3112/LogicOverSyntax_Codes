class Solution(object):
    def binarySearch(self, nums, target):
        start, end = 0, len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == target:
                return True
            if nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return False

    def intersection(self, nums1, nums2):
        nums1.sort()
        nums2.sort()
        result = []
        didWeTrackedAlready = [False] * 10001

        for num in nums1:
            if didWeTrackedAlready[num]:
                continue
            didWeTrackedAlready[num] = True
            if self.binarySearch(nums2, num):
                result.append(num)

        return result
