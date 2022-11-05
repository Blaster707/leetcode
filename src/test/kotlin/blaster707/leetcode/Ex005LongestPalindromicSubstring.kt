package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex005LongestPalindromicSubstring {

    class Solution {

        @Test
        fun solution() {

        }

        fun longestPalindrome(s: String): String {
            var lastPointer = s.length-1
            for (x in s) {
                while (lastPointer != s.indexOf(x)) {
                    if (s[lastPointer] == x) {

                    }
                    lastPointer -= 1
                }
            }
            return "hi"
        }

        fun isPalindrome(x: String): Boolean {


            var startChar = 0
            var endChar = x.length-1
            var result = true
            while (startChar != endChar) {
                if (startChar>endChar) {
                    break
                } else {
                    if (x[startChar] == x[endChar]) {
                        startChar++
                        endChar--
                    } else {
                        result = false
                        startChar = endChar
                    }
                }

            }
            return result
        }
    }
}