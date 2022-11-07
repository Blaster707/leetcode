package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex005LongestPalindromicSubstring {

    class Solution {

        @Test
        fun solution() {
            assert(longestPalindrome("babad") == "bab")
            assert(longestPalindrome("aacabdkacaa") == "aca")
        }

        fun longestPalindrome(s: String): String {
            var answer = s[0].toString()
            for (i in s.length downTo 1) {
                for (x in 0..s.length-i) {
                    if (isPalindrome(s, x, i)) {
                        return s.substring(x, i+x)
                    }
                }
            }
            return answer
        }

        fun isPalindrome(s: String, x: Int, z: Int): Boolean {
            for (i in 0..z/2) {
                if (s[x+i] != s[x+z-1-i]) {
                    return false
                }
            }
            return true
        }
    }
}