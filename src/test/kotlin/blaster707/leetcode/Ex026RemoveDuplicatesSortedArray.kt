package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex026RemoveDuplicatesSortedArray {

    class Solution {

        @Test
        fun solution() {
            assert(removeDuplicates((intArrayOf(1, 1, 2))) == 2)
            assert(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)) == 5)
        }

        fun removeDuplicates(nums: IntArray): Int {
            var indexInt = 0
            var indexReplacer = 1
            while (nums[nums.lastIndex] > nums[indexInt]) {
                    indexInt = nums.indexOfLast {it == nums[indexInt]}
                    nums[indexReplacer] = nums[indexInt+1]
                    indexInt++
                    indexReplacer++
                }
            return indexReplacer
        }
    }
}