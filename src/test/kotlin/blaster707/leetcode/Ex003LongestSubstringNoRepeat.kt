package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex003LongestSubstringNoRepeat {

    class Solution {

        @Test
        fun solution(){
            assert(lengthOfLongestSubstring("abcabcbb") == 3)
            assert(lengthOfLongestSubstring("pwwkew") == 3)
            assert(lengthOfLongestSubstring("au") == 2)

        }

        fun lengthOfLongestSubstring(s: String): Int {

            if (s.isEmpty()) {return 0}
            if (s.length == 1) {return 1}
            var answer = 0
            var stringStart = 0
            var complete = false

            fun substringChecker(subS: String, charPointer: Int, x: Int){
                if (complete) {
                    return
                }
                if (charPointer>s.length-1) {
                    if (x>answer) {answer = x}
                    complete = true
                    return
                }
                if (s[charPointer] in subS) {
                    if (x>answer) {answer = x}
                    complete = true
                    return
                } else {
                    substringChecker(subS+s[charPointer], charPointer+1, x+1)
                }
            }
            do {
                if (complete) {
                    stringStart++
                    complete = false
                }
                substringChecker("", stringStart, 0)
            } while (s.length >= answer+stringStart)
            return answer
        }
    }
}