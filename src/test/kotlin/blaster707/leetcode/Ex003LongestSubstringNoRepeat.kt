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
            var subString = ""

            for (i in s) {
                while (i in subString) {
                    subString = subString.drop(1)
                }
                subString = subString.plus(i)
                if (subString.length > answer) {answer = subString.length}
            }

            return answer

        }
    }
}