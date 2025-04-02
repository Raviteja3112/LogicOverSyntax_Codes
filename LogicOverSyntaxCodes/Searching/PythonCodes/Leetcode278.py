class Solution(object):
    def firstBadVersion(self, n):
        start, end = 1, n

        while start < end:
            version = start + (end - start) // 2
            if isBadVersion(version):
                end = version
            else:
                start = version + 1

        return start
