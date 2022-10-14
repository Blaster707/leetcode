package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex012IntegertoRoman {
    class Solution {

        @Test
        fun solution(){

            assert(intToRoman(2000) == "MM")
            assert(intToRoman(3) == "III")
            assert(intToRoman(58) == "LVIII")
            assert(intToRoman(1994) == "MCMXCIV")
        }

        fun intToRoman(num: Int): String {

            var x = num
            var answer = ""

            while (x != 0) {
                when {
                    x >= 1000 -> {for (i in 1..(x/1000)) {answer = answer.plus('M')}; x%=1000}
                    x >= 900 -> {answer = answer.plus("CM"); x-=900}
                    x >= 500 -> {answer = answer.plus("D"); x-=500}
                    x >= 400 -> {answer = answer.plus("CD"); x-=400}
                    x >= 100 -> {for (i in 1..(x/100)) {answer = answer.plus('C')}; x%=100}
                    x >= 90 -> {answer = answer.plus("XC"); x-=90}
                    x >= 50 -> {answer = answer.plus("L"); x-=50}
                    x >= 40 -> {answer = answer.plus("XL"); x-=40}
                    x >= 10 -> {for (i in 1..(x/10)) {answer = answer.plus('X')}; x%=10}
                    x >= 9 -> {answer = answer.plus("IX"); x = 0}
                    x >= 5 -> {answer = answer.plus("V"); x-=5}
                    x >= 4 -> {answer = answer.plus("IV"); x = 0}
                    x >= 1 -> {for (i in 1..(x/1)) {answer = answer.plus('I')}; x = 0}
                }
            }
            return answer
        }
    }
}