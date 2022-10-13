package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex028FindFirstOccurrence {

    class Solution {

        @Test
        fun solution() {
           /* assert(strStr("sadbutsad", "sad") == 0)
            assert(strStr("leetcode", "leeto") == -1)
            assert(strStr("hello", "ll") == 2)
            assert(strStr("aaa", "aaaa") == -1)*/
            assert(strStr("mississippi", "issip") == 4)
        }

        fun strStr(haystack: String, needle: String): Int {
            var haystackOffset = 0
            var haystackPointer: Int
            var needlePointer = 0
            var answer: Int
                for (i in haystack.indices) {
                    answer = i
                    haystackPointer = i
                    for (x in needle.indices) {
                         if (haystackPointer == haystack.length) {return -1}
                        if (haystack[x+haystackOffset] == needle[x]) {
                            needlePointer++
                            haystackPointer++
                            if (needlePointer == needle.length) {return answer}
                        } else {
                            needlePointer = 0
                            haystackOffset++
                            break
                        }
                    }
                }

            return -1
        }
    }
}