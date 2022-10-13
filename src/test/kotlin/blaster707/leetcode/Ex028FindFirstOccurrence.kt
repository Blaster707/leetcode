package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex028FindFirstOccurrence {

    class Solution {

        @Test
        fun solution() {
            assert(strStr("sadbutsad", "sad") == 0)
            assert(strStr("leetcode", "leeto") == -1)
            assert(strStr("hello", "ll") == 2)
            assert(strStr("aaa", "aaaa") == -1)
            assert(strStr("mississippi", "issip") == 4)
        }

        fun strStr(haystack: String, needle: String): Int {

            return haystack.indexOf(needle)

        }
    }
}