package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex033SearchinRotatedSortArray {

    class Solution {

        @Test
        fun solution() {
            assert(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0) == 4)
            assert(search(intArrayOf(1, 3), 3) == 1)
        }

        fun search(nums: IntArray, target: Int): Int {
            if (nums.isEmpty()) {
                return -1
            }
            if (nums.size == 1) {
                return if (nums[0] == target) {
                    0
                } else -1
            }
            var answer = -1
            var complete = false

            fun numsBinarySearcher(lowPoint: Int, highPoint: Int) {
                while (!complete) {
                    val midPoint = (lowPoint + highPoint) / 2
                    if (nums[midPoint] == target) {
                        answer = midPoint
                        complete = true
                        return
                    }
                    if (lowPoint == midPoint || highPoint == midPoint) {
                        if (nums[lowPoint] == target) {answer = lowPoint}
                        if (nums[highPoint] == target) {answer = highPoint}
                        complete = true
                        return
                    }
                    if (nums[midPoint] < nums[highPoint]) {
                        if (nums[midPoint] <= target && target <= nums[highPoint]) {
                            numsBinarySearcher(midPoint, highPoint)
                        } else {
                            numsBinarySearcher(lowPoint, midPoint)
                        }
                    }
                    if (nums[lowPoint] <= target && target <= nums[midPoint]) {
                        numsBinarySearcher(lowPoint, midPoint)
                    } else {
                        numsBinarySearcher(midPoint, highPoint)
                    }
                }
            }
            numsBinarySearcher(0, nums.size - 1)
            return answer
        }
    }
}