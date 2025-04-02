class Solution:
    def binary_search(self, nums, target, index):
        start, end = index, len(nums) - 1

        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1

    def twoSum(self, numbers, target):
       
        for i in range(len(numbers)):
            find = target - numbers[i]
            index = self.binary_search(numbers, find, i + 1)
            if index != -1:
                return [i + 1, index + 1]
        return [0, 0]
