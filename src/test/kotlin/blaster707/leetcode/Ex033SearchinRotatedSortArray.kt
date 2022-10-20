package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex033SearchinRotatedSortArray {

    class Solution {

        @Test
        fun solution(){
            assert(search(intArrayOf(4,5,6,7,0,1,2), 0) == 4)
            assert(search(intArrayOf(1, 3), 3) == 1)
        }
        fun search(nums: IntArray, target: Int): Int {
            if (nums.isEmpty()) {return -1}
            if (nums.size == 1) {
                return if (nums[0] == target) {
                    0
                } else -1
            }
            if (target in nums) {
                return nums.indexOf(target)
            }
            else return -1
        }

    }
}