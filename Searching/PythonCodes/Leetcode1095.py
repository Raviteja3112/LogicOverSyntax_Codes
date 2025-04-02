class Solution(object):
    def binarySearch(self, mountainArr, target, isAscending, start, end):
        while start <= end:
            mid = start + (end - start) // 2
            mid_value = mountainArr.get(mid)
            
            if mid_value == target:
                return mid
            
            if isAscending:
                if mid_value > target:
                    end = mid - 1
                else:
                    start = mid + 1
            else:
                if mid_value > target:
                    start = mid + 1
                else:
                    end = mid - 1
                    
        return -1
    
    def findInMountainArray(self, target, mountainArr):
        start, end = 0, mountainArr.length() - 1
        
        while start < end:
            mid = start + (end - start) // 2
            if mountainArr.get(mid) > mountainArr.get(mid + 1):
                end = mid
            else:
                start = mid + 1
        
        peakIndex = start
        index = self.binarySearch(mountainArr, target, True, 0, peakIndex)
        if index != -1:
            return index
        
        return self.binarySearch(mountainArr, target, False, peakIndex + 1, mountainArr.length() - 1)








        