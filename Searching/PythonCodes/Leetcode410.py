class Solution(object):
    def canISplitAtMaxK(self, nums, k, maxSum):
        tempK, total = 1, 0
        
        for num in nums:
            if total + num <= maxSum:
                total += num
            else:
                tempK += 1
                total = num
        
        return tempK <= k
    
    def splitArray(self, nums, k):
        max_num, total_sum = max(nums), sum(nums)
        start, end = max_num, total_sum
        
        while start < end:
            mid = start + (end - start) // 2
            if self.canISplitAtMaxK(nums, k, mid):
                end = mid
            else:
                start = mid + 1
        
        return end