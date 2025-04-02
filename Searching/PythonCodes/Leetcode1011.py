class Solution(object):
    def canITransport(self, weights, days, capacity):
        ship_weight = 0
        temp_days = 1

        for weight in weights:
            if ship_weight + weight <= capacity:
                ship_weight += weight
            else:
                temp_days += 1
                ship_weight = weight

        return temp_days <= days

    def shipWithinDays(self, weights, days):
        max_weight = max(weights)
        total_weight = sum(weights)

        start, end = max_weight, total_weight

        while start <= end:
            mid = start + (end - start) // 2
            if self.canITransport(weights, days, mid):
                end = mid - 1
            else:
                start = mid + 1

        return start
