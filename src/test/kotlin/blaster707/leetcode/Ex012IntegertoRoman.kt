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

            var answer = ""
            when {
                num >= 1000 -> {for (i in 1..(num / 1000)) {answer = answer.plus('M')}; return answer + intToRoman(num % 1000)}
                num >= 900 -> {answer = answer.plus("CM"); return answer + intToRoman(num-900)}
                num >= 500 -> {answer = answer.plus("D"); return answer + intToRoman(num-500)}
                num >= 400 -> {answer = answer.plus("CD"); return answer + intToRoman(num-400)}
                num >= 100 -> {for (i in 1..(num/100)) {answer = answer.plus('C')}; return answer + intToRoman(num % 100)}
                num >= 90 -> {answer = answer.plus("XC"); return answer + intToRoman(num-90)}
                num >= 50 -> {answer = answer.plus("L"); return answer + intToRoman(num-50)}
                num >= 40 -> {answer = answer.plus("XL"); return answer + intToRoman(num-40)}
                num >= 10 -> {for (i in 1..(num/10)) {answer = answer.plus('X')}; return answer + intToRoman(num % 10)}
                num >= 9 -> {answer = answer.plus("IX"); return answer}
                num >= 5 -> {answer = answer.plus("V"); return answer + intToRoman(num-5)}
                num >= 4 -> {answer = answer.plus("IV"); return answer}
                num >= 1 -> {for (i in 1..(num/1)) {answer = answer.plus('I')}; return answer}
                else -> return ""
                }
            }
        }
    }