class Solution(object):
    def arrangeCoins(self, n):
        
        start, end = 1, n
        if n == 1:
            return 1
        while start < end:
            stairs = start + (end - start) // 2
            enniKavali = (stairs * (stairs + 1)) // 2
            if enniKavali > n:
                end = stairs
            else:
                start = stairs+1
        return end-1
