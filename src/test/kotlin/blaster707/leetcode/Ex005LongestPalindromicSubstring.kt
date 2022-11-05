package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex005LongestPalindromicSubstring {

    class Solution {

        @Test
        fun solution() {
            //assert(longestPalindrome("babad") == "bab")
            assert(longestPalindrome("aacabdkacaa") == "aca")
        }

        fun longestPalindrome(s: String): String {
            var answer = "${s[0]}"
            var xPointer = 0
            for (x in s) {
                var lastPointer = s.length-1
                if (s.length-1-xPointer < answer.length) {return answer}
                while (lastPointer != xPointer) {
                    if (s[lastPointer] == x) {
                        val subString = s.substring(xPointer, lastPointer+1)
                        if (isPalindrome(subString)) {
                            if (subString.length > answer.length) {
                                answer = subString
                                if (s.length-1-xPointer < answer.length) {return answer}
                                continue
                            }
                        }
                    }
                    if (lastPointer-1 == xPointer) {xPointer++; continue}
                    lastPointer -= 1
                }
            }
            return answer
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