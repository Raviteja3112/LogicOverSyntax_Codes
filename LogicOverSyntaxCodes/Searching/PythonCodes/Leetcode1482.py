class Solution(object):
    def canIMakeBouquet(self, bloomDay, m, k, day):
        bouquets = 0
        flowers = 0
        
        for bloom in bloomDay:
            if bloom <= day:
                flowers += 1
            else:
                flowers = 0
            
            if flowers == k:
                bouquets += 1
                flowers = 0
            
            if bouquets == m:
                return True
        
        return False
    
    def minDays(self, bloomDay, m, k):
        if m * k > len(bloomDay):
            return -1
        
        start, end = 1, max(bloomDay)
        
        while start <= end:
            day = start + (end - start) // 2
            if self.canIMakeBouquet(bloomDay, m, k, day):
                end = day - 1
            else:
                start = day + 1
        
        return start