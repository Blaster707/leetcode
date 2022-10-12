package blaster707.leetcode

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactly

class Ex026RemoveDuplicatesSortedArray {

    class Solution {

        @Test
        fun solution() {
            val expected = intArrayOf(1, 2).toList()
            val actual = intArrayOf(1, 1, 2)
            assert(removeDuplicates(actual) == 2)
            expectThat(actual.toList().subList(0, 2)) {
                containsExactly(expected)
            }
            assert(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)) == 5)
            assert(removeDuplicates(intArrayOf(1, 1)) == 1)
        }

        fun removeDuplicates(nums: IntArray): Int {
            var current = 0
            for (i in nums.indices) {
                if (nums[current] < nums[i]) {
                    current += 1
                    nums[current] = nums[i]
                }
            }

            return current + 1
        }
    }
}