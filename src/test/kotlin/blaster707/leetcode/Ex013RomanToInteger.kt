package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex013RomanToInteger {
    class Solution {

        @Test
        fun solution() {
            assert(romanToInt("III") == 3)
            assert(romanToInt("IV") == 4)
            assert(romanToInt("LVIII") == 58)
            assert(romanToInt("MCMXCIV") == 1994)
        }

        fun romanToInt(s: String): Int {

            var indexInt = 0
            var totalInt = 0
            while (s.length > indexInt) {
                when {
                    s.startsWith("IV", indexInt) -> {indexInt += 2; totalInt += 4}
                    s.startsWith("IX", indexInt) -> {indexInt += 2; totalInt += 9}
                    s.startsWith("I", indexInt) -> {indexInt++; totalInt++}
                    s.startsWith("V", indexInt) -> {indexInt++; totalInt += 5}
                    s.startsWith("XL", indexInt) -> {indexInt +=2; totalInt += 40}
                    s.startsWith("XC", indexInt) -> {indexInt +=2; totalInt += 90}
                    s.startsWith("X", indexInt)-> {indexInt++; totalInt+= 10}
                    s.startsWith("L", indexInt) -> {indexInt++; totalInt += 50}
                    s.startsWith("CD", indexInt)-> {indexInt +=2; totalInt += 400}
                    s.startsWith("CM", indexInt)-> {indexInt +=2; totalInt += 900}
                    s.startsWith("C", indexInt)-> {indexInt++; totalInt+= 100}
                    s.startsWith("D", indexInt) -> {indexInt++; totalInt += 500}
                    s.startsWith("M") -> {indexInt++; totalInt += 1000}
                }
            }
            return totalInt
        }
    }
}
