/**
 * Definition of Interval:
 * class Interval  {
 *   constructor(start, end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */

class Solution {
    /**
     * @param {Interval[]} intervals
     * @returns {boolean}
     */
    canAttendMeetings(intervals: Interval[]): boolean {
        let n: number = intervals.length;
        if (n === 0 || n === 1) return true;
        intervals.sort((a, b) => {
            if (a.start !== b.start) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });
        for (let i: number = 1; i < n; i++) {
            if (intervals[i].start < intervals[i - 1].end) return false;
        }
        return true;
    }
}
