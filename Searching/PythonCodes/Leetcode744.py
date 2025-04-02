class Solution(object):
    def nextGreatestLetter(self, letters, target):

        start, end = 0, len(letters) - 1

        while start < end:
            mid = start + (end - start) // 2
            if target >= letters[mid]:
                start = mid + 1
            else:
                end = mid
        
        return letters[start] if letters[start] > target else letters[0]
