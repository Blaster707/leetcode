package blaster707.leetcode

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.*

class Ex001TwoSum {

    @Test
    fun solution(){
        assert(twoSum(nums = intArrayOf(3, 4, 6), target = 7).contentEquals(intArrayOf(0, 1)))
        assert(twoSum(nums = intArrayOf(1, 5, 6, 9, 12), target = 14).contentEquals(intArrayOf(1, 3)))

        val actual = twoSum(nums = intArrayOf(3, 4, 6), target = 7)
        expectThat(actual.toList()) {
            containsExactly(0, 1)
        }
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        var x = 0
        var y = 0
        var foundResult = false
        while (!foundResult) {
            for (num in nums.indices) {
                if (map.containsKey(nums[num])) {
                    x = map[nums[num]]!!
                    y = num
                    foundResult = true
                }
                map[target - nums[num]] = num //This puts into the map the index location for this integer, and the necessary integer to add up to the value.
                // when the necessary integer appears, the program adds it to "x" and "y", ends the loop and returns the intarray.
            }
        }
        return intArrayOf(x, y)
    }
}