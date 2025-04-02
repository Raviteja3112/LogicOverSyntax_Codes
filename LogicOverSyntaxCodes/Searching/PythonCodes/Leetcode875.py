class Solution(object):
    def canIEatWithKCapacity(self, piles, capacity, hours):
        for bananas in piles:
            if hours < 0:
                return False
            hour_to_finish = (bananas + capacity - 1) // capacity
            hours -= hour_to_finish
        return hours >= 0

    def minEatingSpeed(self, piles, h):
        max_capacity = max(piles)
        start, end = 1, max_capacity

        while start < end:
            capacity = start + (end - start) // 2
            if self.canIEatWithKCapacity(piles, capacity, h):
                end = capacity
            else:
                start = capacity + 1

        return start
