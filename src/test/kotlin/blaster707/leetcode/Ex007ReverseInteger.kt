package blaster707.leetcode

import org.junit.jupiter.api.Test
import kotlin.math.abs

class Ex007ReverseInteger {
    class Solution {

        @Test
        fun solution() {
            assert(reverse(1534236469) == 0)
            assert(reverse(-915) == -519)
            assert(reverse(-2147483648) == 0)

        }
        fun reverse(x: Int): Int {
            val string = abs(x.toLong()).toString()
            val answer = string.reversed().toLong()



            return if (answer !in -2147483648..2147483648) {
                0
            } else if (x < 0) {
                (0-answer.toInt())
            } else {
                answer.toInt()
            }

        }
    }
}