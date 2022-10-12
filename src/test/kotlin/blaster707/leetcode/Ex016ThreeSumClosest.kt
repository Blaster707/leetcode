package blaster707.leetcode

import org.junit.jupiter.api.Test
import kotlin.math.abs

class Ex016ThreeSumClosest {

    class Solution {

        @Test
        fun solution() {
            assert(threeSumClosest(nums = intArrayOf(-1, 2, 1, -4), 1) == 2)
            assert(threeSumClosest(nums = intArrayOf(0, 0, 0), 1) == 0)
        }

        fun threeSumClosest(nums: IntArray, target: Int): Int {

            nums.sort()
            var answer = nums[0] + nums[1] + nums[2]


            for (x in 0..(nums.size-2)) {
                var lowerPointer = x+1
                var upperPointer = nums.size-1
                while (lowerPointer<upperPointer) {
                    val sum = nums[lowerPointer] + nums[upperPointer] + nums[x]
                    if (sum == target) {
                        return sum
                    }
                    if (sum > target) {
                        upperPointer--
                    } else {
                        lowerPointer++
                    }
                    if (abs(sum - target) < abs(answer - target)) {
                        answer = sum
                    }

                }
            }

            return answer

        }
    }
}