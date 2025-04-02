class Solution(object):
    def canIPickThisNumber(self, nums, x, threshold):
        total = 0
        for num in nums:
            total += (num + x - 1) // x
            if total > threshold:
                return False
        return True

    def smallestDivisor(self, nums, threshold):
        max_value = max(nums)
        start, end = 1, max_value

        while start <= end:
            x = start + (end - start) // 2
            if self.canIPickThisNumber(nums, x, threshold):
                end = x - 1
            else:
                start = x + 1

        return start
