class Solution(object):
    def mySqrt(self, x):
        start, end = 0, x

        while start <= end:
            mid = start + (end - start) // 2
            value = mid * mid
            if value == x:
                return mid
            if value > x:
                end = mid - 1
            else:
                start = mid + 1

        return end
