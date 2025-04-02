class Solution(object):
    def findKthPositive(self, arr, k):
        
        start, end = 0, len(arr) - 1

        while start <= end:
            mid = start + (end - start) // 2
            one_based_indexed = mid + 1
            missing_elements = arr[mid] - one_based_indexed
            
            if k > missing_elements:
                start = mid + 1
            else:
                end = mid - 1

        return start + k
