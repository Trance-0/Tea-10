class Solution:
    def maximumWeight(self, intervals: List[List[int]]) -> List[int]:
        res = []
        n = len(intervals)
        # sort intervals by start time, then by end time, then by weight, then by index
        intervals = sorted([[intervals[i][0], intervals[i][1], intervals[i][2], i] for i in range(n)], key=lambda x: (x[0], x[1], x[2]))
        @lru_cache(None)
        def curMaximumWeight(idx,k) -> tuple[int, str]:
            if idx >= n or k == 0:
                return 0, ""
            # find next non overlapping interval
            next_idx = bisect.bisect_left(intervals, [intervals[idx][1]+1, 0, 0, 0], idx+1, n)
            pick_weight, pick_intervals = curMaximumWeight(next_idx, k-1)
            not_pick_weight, not_pick_intervals = curMaximumWeight(idx+1, k)
            if pick_weight + intervals[idx][2] > not_pick_weight:
                new_intervals = [int(i) for i in pick_intervals.split(",")] if pick_intervals else []
                new_intervals.append(intervals[idx][3])
                new_intervals.sort()
                pick_intervals = ",".join([str(i) for i in new_intervals])
                return pick_weight + intervals[idx][2], pick_intervals
            elif pick_weight + intervals[idx][2] == not_pick_weight:
                new_intervals = [int(i) for i in pick_intervals.split(",")] if pick_intervals else []
                new_intervals.append(intervals[idx][3])
                new_intervals.sort()
                new_intervals = min(new_intervals, [int(i) for i in not_pick_intervals.split(",")] if not_pick_intervals else [])
                pick_intervals = ",".join([str(i) for i in new_intervals])
                return pick_weight + intervals[idx][2], pick_intervals
            else:
                return not_pick_weight, not_pick_intervals
        return [int(i) for i in curMaximumWeight(0,4)[1].split(",")]