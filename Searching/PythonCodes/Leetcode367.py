class Solution(object):
    def isPerfectSquare(self, num):
        start, end = 1, num

        while start <= end:
            mid = start + (end - start) // 2
            square = mid * mid
            
            if square == num:
                return True
            elif square > num:
                end = mid - 1
            else:
                start = mid + 1
        
        return False
