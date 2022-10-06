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
            while (s.length > indexInt+1) {
                when(s[indexInt]) {
                    'I' -> when(s[indexInt+1]) {
                        'V' -> {indexInt += 2; totalInt += 4}
                        'X' -> {indexInt += 2; totalInt += 9}
                        else -> {indexInt++; totalInt++}
                    }
                    'V' -> {indexInt++; totalInt += 5}
                    'X' -> when(s[indexInt+1]) {
                        'L' -> {indexInt +=2; totalInt += 40}
                        'C' -> {indexInt +=2; totalInt += 90}
                        else -> {indexInt++; totalInt+= 10}
                        }
                    'L' -> {indexInt++; totalInt += 50}
                    'C' -> when(s[indexInt+1]) {
                        'D' -> {indexInt +=2; totalInt += 400}
                        'M' -> {indexInt +=2; totalInt += 900}
                        else -> {indexInt++; totalInt+= 100}
                    }
                    'D' -> {indexInt++; totalInt += 500}
                    'M' -> {indexInt++; totalInt += 1000}
                }
            }
            if(indexInt+1 == s.length)
            return when(s[indexInt]) {
                'I' -> totalInt+1
                'V' -> totalInt+5
                'X' -> totalInt+10
                'L' -> totalInt+50
                'C' -> totalInt+100
                'D' -> totalInt+500
                'M' -> totalInt+1000
                else -> throw Exception("Invalid Entry")
            } else return totalInt
        }
    }
}