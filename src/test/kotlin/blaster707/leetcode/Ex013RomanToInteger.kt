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
            return romanToIntCalculator(s).second
        }

        fun romanToIntCalculator(x: String?, totalInt: Int = 0): Pair<String?, Int> {
            while(x != null && x.length > 0) {
                return when (x.get(0)) {
                    'I' -> {
                        when {
                            (x.length > 1 && x.get(1) == 'V') -> Pair(x.removeRange(0, 2), (4 + romanToIntCalculator(x.removeRange(0, 2), totalInt).second))
                            (x.length > 1 && x.get(1) == 'X') -> Pair(x.removeRange(0, 2), (9 + romanToIntCalculator(x.removeRange(0, 2), totalInt).second))
                            else -> Pair(x.removeRange(0, 1), (1 + romanToIntCalculator(x.removeRange(0, 1), totalInt).second))
                        }
                    }

                    'V' -> Pair(x.removeRange(0, 1), (5 + romanToIntCalculator(x.removeRange(0, 1), totalInt).second))
                    'X' -> {
                        when {
                            (x.length > 1 && x.get(1) == 'L') -> Pair(x.removeRange(0, 2), (40 + romanToIntCalculator(x.removeRange(0, 2), totalInt).second))
                            (x.length > 1 && x.get(1) == 'C') -> Pair(x.removeRange(0, 2), (90 + romanToIntCalculator(x.removeRange(0, 2), totalInt).second))
                            else -> Pair(x.removeRange(0, 1), (10 + romanToIntCalculator(x.removeRange(0, 1), totalInt).second))
                        }
                    }

                    'L' -> Pair(x.removeRange(0, 1), (50 + romanToIntCalculator(x.removeRange(0, 1), totalInt).second))
                    'C' -> {
                        when {
                            (x.length > 1 && x.get(1) == 'D') -> Pair(x.removeRange(0, 2), (400 + romanToIntCalculator(x.removeRange(0, 2), totalInt).second))
                            (x.length > 1 && x.get(1) == 'M') -> Pair(x.removeRange(0, 2), (900 + romanToIntCalculator(x.removeRange(0, 2), totalInt).second))
                            else -> Pair(x.removeRange(0, 1), (100 + romanToIntCalculator(x.removeRange(0, 1), totalInt).second))
                        }
                    }

                    'D' -> Pair(x.removeRange(0, 1), (500 + romanToIntCalculator(x.removeRange(0, 1), totalInt).second))
                    'M' -> Pair(x.removeRange(0, 1), (1000 + romanToIntCalculator(x.removeRange(0, 1), totalInt).second))
                    else -> throw Exception("Invalid Entry")
                }
            }

            return Pair(first = null, second = totalInt)

        }
    }
}