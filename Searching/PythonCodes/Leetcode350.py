class Solution(object):
    def binary_search(self, nums, target):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1

    def intersect(self, nums1, nums2):
        nums1.sort()
        nums2.sort()
        result = []
        for num in nums1:
            index = self.binary_search(nums2, num)
            if index != -1:
                result.append(num)
                nums2[index] = -1  
                nums2.sort()  
        
        return result
