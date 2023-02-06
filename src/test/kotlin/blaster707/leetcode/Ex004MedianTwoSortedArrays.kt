package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex004MedianTwoSortedArrays {

    class Solution {

        @Test
        fun solution(){
            assert((findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))) == 2.00000)
            assert((findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)) == 2.50000))
        }

        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            val mergedArray = arrayMerger(nums1, nums2)
            println(mergedArray.contentToString())

            if (mergedArray.size % 2 == 1){
                return mergedArray[((mergedArray.size-1)/2)].toDouble()
            } else {
                val x = mergedArray[((mergedArray.size/2))].toDouble()
                val y = mergedArray[((mergedArray.size/2)-1)].toDouble()
                return (x+y)/2
            }
        }

        fun arrayMerger(numsX: IntArray, numsY: IntArray): IntArray {
            return when {
                numsX.isEmpty() -> numsY
                numsY.isEmpty() -> numsX
                numsX[0] < numsY[0] -> intArrayOf(numsX[0]).plus(arrayMerger(numsX.drop(1).toIntArray(), numsY))
                else -> intArrayOf(numsY[0]).plus(arrayMerger(numsX, numsY.drop(1).toIntArray()))
            }
        }
    }

}